package ejemplos;

import java.util.Scanner;

public class ContarCifras {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = teclado.nextInt();
        teclado.close();

        int sumaPares = 0, sumaImpares = 0;
        boolean hayPares = false;
        
        String numeroTxt = String.valueOf(numero);
        for(int i=0; i<numeroTxt.length(); i++) {
        	if((numeroTxt.charAt(i)-'0') %2 ==0){
        		sumaPares+=numeroTxt.charAt(i)-'0';
        				hayPares = true;
        	}
        	else	
        		sumaImpares+=numeroTxt.charAt(i)-'0';
        }
        if(hayPares == true)
        	System.out.println("Las suma de las cifras pares es " + sumaPares);
        else
        	System.out.println("No hay cifras pares");
        if(sumaImpares!=0)
        	System.out.println("Las suma de las cifras impares es " + sumaImpares);   	
        else
        	System.out.println("No hay cifras impares");
	}
}
