
public class MainTest {
	
	public static void main(String[] args) {
		String text = "WHERE ACCOUNTS.CRM.accountNumber=CONTACTS.CRM.accountNumber AND CONTACTS.CRM.accountNumber!=CONTACTS.Billing.accountNumber OR 			    CONTACTS.CRM.address2!=CONTACTS.Billing.address2 OR CONTACTS.CRM.firstName!=CONTACTS.Billing.firstName OR CONTACTS.CRM.zipCode!=CONTACTS.Billing.zipCode AND CONTACTS.CRM.emailAddress!=CONTACTS.Billing.emailAddress OR CONTACTS.CRM.phone!=CONTACTS.Billing.phone AND CONTACTS.CRM.lastName!=CONTACTS.Billing.lastName";
		System.out.println(text);
		String convertedString = getConvertedString(text);
		System.out.println(convertedString);
		
	}
	
	public static String getConvertedString(String text){
		StringBuffer sb = new StringBuffer();
		String[] s = text.split(" AND ");
		if(s.length>2){
			sb.append(s[0]+" AND (");//Index 0
			for(int i=1;i<s.length-1;i++){
				sb.append(s[i]+") AND (");
			}
		}
		sb = new StringBuffer(sb.toString().substring(0,sb.length()-1));
		sb.append(s[s.length-1]);
		return sb.toString();
	}

}
