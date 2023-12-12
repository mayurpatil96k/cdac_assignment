package mvc_assi;

public class CareerExpert {
public String getAdvice(String value) {
    if (value.equals("BE")) {
        return "GO FOR BUSINESS, DON'T DO ANY OTHER STUFF";
    } else if (value.equals("BSC")) {
        return "AB KYA HI KARNA HAI, SHADI KARLO";
    } else if (value.equals("DOCTOR")) {
        return "TUM PE TO SAB KUCH HAI, TUME AGE KYA HI KARNA PADEGA";
    } else if (value.equals("MBA")) {
        return "GO FOR CHAI KI DUKAN";
    } else {
        return "TUNE JO BHI KIYA HAI, USKE BAD TUMHE CDAC HI KARNA HOGA";
    }
}
}
