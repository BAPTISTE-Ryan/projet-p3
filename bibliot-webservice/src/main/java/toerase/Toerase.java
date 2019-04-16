package toerase;

import org.occ.p3.service.BatchService;
import org.occ.p3.service.BatchServiceImpl;
import org.occ.p3.webservice.WebServiceBatch;
import org.springframework.beans.factory.annotation.Autowired;

public class Toerase {

	@Autowired
	BatchService batchService;

	
	static
	BatchServiceImpl batchServiceimpl = new BatchServiceImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String to ="mr.ryan.baptiste@gmail.com";
		
		/*
		WebServiceBatch wsb = new WebServiceBatch();
		wsb.send2("mr.ryan.baptiste@gmail.com", "mr.ryan.baptiste@gmail.com", "mr.ryan.baptiste@gmail.com");
		
		
		BatchServiceImpl bs = new BatchServiceImpl();;
		 
		
		bs.send(to, to, to);
		*/
		
				batchServiceimpl.send(to, to, to);
		
		//batchService.send(to, to, to);
		//batchService.send(   to, sub, msg);
	}

}
