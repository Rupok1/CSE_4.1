import java.math.BigDecimal;
import java.math.BigInteger;

public class RSA_2 {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("656692050181897513638241554199181923922955921760928836766304161790553989228223793461834703506872747071705167995972707253940099469869516422893633357693");
        BigInteger q = new BigInteger("204616454475328391399619135615615385636808455963116802820729927402260635621645177248364272093977747839601125961863785073671961509749189348777945177811");

        BigInteger N = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
        System.out.println(N+"\n"+phi);
        BigInteger x = BigInteger.ZERO;
        BigInteger e = BigInteger.TWO;

        while(true)
        {
            x = e.gcd(phi);
            if(x.compareTo(BigInteger.ONE)==0)break;
            e = e.add(BigInteger.ONE);
        }

        BigDecimal k = BigDecimal.TWO;
        BigDecimal d2 = BigDecimal.ZERO;
        BigDecimal z = new BigDecimal(phi);
        BigDecimal e2 = new BigDecimal(e);

        while(true)
        {
            d2 = (k.multiply(z).add(BigDecimal.ONE)).divide(e2);
            BigDecimal p1 = new BigDecimal(d2.toBigInteger());
            if(d2.compareTo(p1)==0)break;
        }

        BigInteger d = d2.toBigInteger();

        BigInteger m1 = new BigInteger("13726");
        BigInteger m2 = new BigInteger("23455");

        BigInteger m = m1.multiply(m2);

        BigInteger c1 = m1.modPow(e,N);
        BigInteger c2 = m2.modPow(e,N);

        BigInteger c = c1.multiply(c2);

        BigInteger dec_msg_1 = c1.modPow(d,N);
        BigInteger dec_msg_2 = c2.modPow(d,N);

        BigInteger decrypt_c = c.modPow(d,N);

        System.out.println("m1: "+m1+" m2: "+m2+" encrypt_m1: "+c1+" encrypt_m2: "+c2+" dec_msg_1: "+dec_msg_1+" dec_msg_2: "+dec_msg_2+" m1m2: "+m+" decrypt:"+decrypt_c);

    }
}
