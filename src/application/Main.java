package application;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Random sort = new Random();
	static Scanner scan = new Scanner(System.in);
	
	static final String OPCOES[] = {"PEDRA", "PAPEL", "TESOURA", "LAGARTO", "SPOCK"};
	static final byte GANHOU = 1, EMPATE = 0, PERDEU = -1;
	
	static int RESULTADOS[/*PLAYER*/][/*PC*/] = {
			{ 0,-1, 1, 1,-1},
			{ 1, 0,-1,-1, 1},
			{-1, 1, 0, 1,-1},
			{-1, 1,-1, 0, 1},
			{ 1,-1, 1,-1, 0},
	};
	
	static void verificarResultado(byte x, byte y) {
		
		if (RESULTADOS[x][y] == GANHOU) {
			System.out.println("Parabéns, você venceu!!\n\n");
		} else if (RESULTADOS[x][y] == EMPATE) {
			System.out.println("Empate!\n\n");
		} else if (RESULTADOS[x][y] == PERDEU) {
			System.out.println("Sinto muito, você perdeu :(\n\n");
		}
		
	}
	
	static byte escolhaJogador() {
		
		byte x = scan.nextByte();
			if(x == 0) {
				System.out.println("\nAté mais :)");
				System.exit(0);
			}		
		return (byte) (x - 1);
	}
	
	static byte escolhaPC() {
				
		return (byte) sort.nextInt(RESULTADOS.length);
	}
	
	static void telaPrincipal() throws Exception {		
		
		System.out.println("     Escolha uma opção:\n");
			System.out.printf("[1] %s\n[2] %s\n[3] %s\n[4] %s\n[5] %s\n[0] SAIR", OPCOES[0], OPCOES[1], OPCOES[2], OPCOES[3], OPCOES[4]);
				System.out.print("\n\nOpção: ");
				byte jogador = escolhaJogador();					
					byte pc = escolhaPC();
			
		for(byte i = 0; i < 3; i++) {
			System.out.println("...");
			Thread.sleep(1000);
		}
		
		
		System.out.printf("O oponente escolheu %s\n\n",OPCOES[pc]);
				 				 
		verificarResultado(jogador, pc);
				
			telaPrincipal();
	}
	
	public static void main(String[] args) {

		try {
			telaPrincipal();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

}