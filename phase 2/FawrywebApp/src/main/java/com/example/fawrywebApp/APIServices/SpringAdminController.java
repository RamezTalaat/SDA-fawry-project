package com.example.fawrywebApp.APIServices;

import java.util.UUID;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawrywebApp.controller.DiscountController;
import com.example.fawrywebApp.controller.PaymentController;
import com.example.fawrywebApp.controller.RefundController;
import com.example.fawrywebApp.controller.RefundRequestController;
import com.example.fawrywebApp.controller.SearchController;
import com.example.fawrywebApp.controller.TransactionController;
import com.example.fawrywebApp.controller.WalletController;
import com.example.fawrywebApp.database.ActiveSessions;
import com.example.fawrywebApp.database.RefundRequestDatabase;
import com.example.fawrywebApp.model.AddToWallet;
import com.example.fawrywebApp.model.Admin;
import com.example.fawrywebApp.model.Discount;
import com.example.fawrywebApp.model.DiscountDecorator;
import com.example.fawrywebApp.model.DiscountType;
import com.example.fawrywebApp.model.RefundRequest;
import com.example.fawrywebApp.model.Response;
import com.example.fawrywebApp.model.Service;
import com.example.fawrywebApp.model.Transaction;
import com.example.fawrywebApp.model.User;

@RestController
@RequestMapping("/AdminController")
public class SpringAdminController {
	@GetMapping("/getTransactions/{uuid}")
	public Response<Vector<Transaction>> getTransactions(@PathVariable ("uuid") UUID uuid) 
	{
		Response<Vector<Transaction>> response=new Response<Vector<Transaction>>();
		ActiveSessions activeSessions=ActiveSessions.getInstance();
		if(!activeSessions.checkSession(uuid) || activeSessions.getUser(uuid).getType().equals("User")) {
			response.setStatus(false);
			response.setMessage("Sorry, you are not an admin!");
			return response;
		}
		TransactionController transactionController=new WalletController();
		if(transactionController.getTransactions().size() == 0) {
			response.setStatus(true);
			response.setMessage("There are no transactions yet!");
			return response;
		}
		response.object=transactionController.getTransactions();
		response.setStatus(true);
		response.setMessage("Transactions retrived succssefully");	
		return response;	
	}
	
	@PostMapping("/addSpecificDiscount/{uuid}/{discountName}/{serviceName}/{amount}")
	public Response addSpecificDiscount (@PathVariable ("uuid") UUID uuid ,@PathVariable ("discountName") String discountName ,
			@PathVariable ("serviceName")String serviceName ,@PathVariable ("amount") int amount) {
		Response response = new Response();
		ActiveSessions activeSessions =ActiveSessions.getInstance();
		if(activeSessions.checkSession(uuid)) {  // if admin had an active session
			System.out.println("Discount "+discountName + " was added to the system"); // for system log purposes
			DiscountDecorator discount =new  DiscountDecorator(amount);
			DiscountController discountController = new DiscountController();
			discount.type = DiscountType.specific;
			discount.name = discountName;
			discount.service = serviceName;
			discountController.makeDiscount(discount);
			response.setStatus(true);
			response.setMessage("Discount : " + discountName + " was added successfully to service " + serviceName);
			return response;
		}
		else { // if admin was not logged in the system
			response.setStatus(false);
			response.setMessage("admin with this uuid is not signed in the system");
			return response;
		}
	}
	
	@PostMapping("/addOverallDiscount/{uuid}/{discountName}/{minimumTransactions}/{maximumTransactions}/{amount}")
	public Response addOverallDiscount (@PathVariable ("uuid") UUID uuid ,@PathVariable ("discountName") String discountName ,
			@PathVariable ("minimumTransactions")int minimumTransactions,@PathVariable ("maximumTransactions")int maximumTransactions ,@PathVariable ("amount") int amount) {
		Response response = new Response();
		ActiveSessions activeSessions =ActiveSessions.getInstance();
		if(activeSessions.checkSession(uuid)) {  // if admin had an active session
			System.out.println("Discount "+discountName + " was added to the system"); // for system log purposes
			DiscountDecorator discount =new  DiscountDecorator(amount);
			DiscountController discountController = new DiscountController();
			discount.type = DiscountType.overall;
			discount.name = discountName;
			discount.minimumTransactions = minimumTransactions;
			discount.maximumTransactions = maximumTransactions;
			discountController.makeDiscount(discount);
			response.setStatus(true);
			response.setMessage("Discount : " + discountName + " ,was added successfully to designated users");
			return response;
		}
		else { // if admin was not logged in the system
			response.setStatus(false);
			response.setMessage("admin with this uuid is not signed in the system");
			return response;
		}
		
		
	}
	
	@GetMapping("/listRefundRequests/{uuid}")
	public Response<Vector<RefundRequest>> listRefundRequests(@PathVariable UUID uuid)
	{
		Response<Vector<RefundRequest>> response = new Response<Vector<RefundRequest>>();
		if(!ActiveSessions.getInstance().checkSession(uuid) || !ActiveSessions.getInstance().getUser(uuid).getType().equals("Admin") ) {
			response.setStatus(false);
			response.setMessage("admin with this uuid is not signed in the system");
			return response;
		}
		response.object = RefundRequestDatabase.getInstance().refundRequests;
		if(response.object.size() == 0) {
			response.setStatus(true);
			response.setMessage("Sorry, no refund requests yet!");
			return response;
		}
		response.setStatus(true);
		response.setMessage("Done, refund requests has been retrived successfully!");
		return response;
	}
	
	@PostMapping("/acceptOrRejectRefundRequest/{uuid}/{refundRequestID}/{answer}")
	public Response<Transaction> acceptOrRejectRefundRequest(@PathVariable ("uuid") UUID uuid, @PathVariable ("refundRequestID") int refundRequestID ,@PathVariable ("answer")String answer ) {
		Response<Transaction> response = new Response<Transaction>(); 
		ActiveSessions sessions = ActiveSessions.getInstance();
		RefundRequestController refundRequestController = new RefundRequestController();
		TransactionController transactionController = new RefundController();
		if(!sessions.checkSession(uuid) || !sessions.getUser(uuid).getType().equals("Admin") ) {
			response.setStatus(false);
			response.setMessage("admin with this uuid is not signed in the system");
			return response;
		}
		RefundRequest refundRequest = refundRequestController.getRefundRequest(refundRequestID);
		if(refundRequest == null) {
			response.setStatus(false);
			response.setMessage("Sorry, wrong refund request ID");
			return response;
		}
		if(answer.equals("reject")){
			refundRequestController.removeRequest(refundRequest, answer);
			response.setStatus(true);
			response.setMessage("Done, refund request has been rejected ");
			return response;
		}
		if(!transactionController.setTransaction(refundRequest.getUser(),refundRequest.getTransaction().getAmount() ,refundRequest.getTransaction(), refundRequest.getTransaction().getService())) {
			response.setStatus(false);
			response.setMessage("Sorry, error occurred");
			return response;
		}
		response.object=refundRequest.getTransaction();
		refundRequestController.removeRequest(refundRequest, answer);
		response.setStatus(true);
		response.setMessage("Done, refund request has been approved");
		return response;
	}
}


