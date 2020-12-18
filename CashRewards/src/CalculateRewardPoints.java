import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CalculateRewardPoints {

	public static void main(String[] args) {
		List<TransactionPojo> list = new ArrayList<>();
		Scanner sc= new Scanner(System.in);
		
		int count = Integer.parseInt(sc.nextLine());
		for(int i=0; i<count;i++) {
			String str = sc.nextLine();
			String[] arr = str.split(",");
			
			TransactionPojo tp = new TransactionPojo();
			tp.setUserName(arr[0]);
			tp.setTransactionAmt(Long.parseLong(arr[1]));
			list.add(tp);
		}
		
		
		Map<String, Long> rewardPointPerCustomer = new HashMap<>();
		for (TransactionPojo transactionPojo : list) {
			Long rewardPts = getRewardForTrasaction(transactionPojo.getTransactionAmt());
			if (!rewardPointPerCustomer.containsKey(transactionPojo.getUserName())) {
				rewardPointPerCustomer.put(transactionPojo.getUserName(), rewardPts);
			} else {
				rewardPointPerCustomer.put(transactionPojo.getUserName(),
						rewardPointPerCustomer.get(transactionPojo.getUserName()) + rewardPts);
			}
		}
		
		
		rewardPointPerCustomer.entrySet().forEach(x->{
			System.out.println("User Name: "+ x.getKey() + " Reward Points Earned: "+x.getValue());
		});

	}

	private static Long getRewardForTrasaction(Long transactionAmt) {
		if (transactionAmt < 50)
			return 0l;
		else if (transactionAmt < 100)
			return 50l;
		else if (transactionAmt > 100)
			return (transactionAmt - 100) * 2 + 50;
		return 0l;
	}

}
