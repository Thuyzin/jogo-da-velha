package org.example.jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        Campo[][] velha = new Campo[3][3];
        char simboloAtual='x';
        Boolean game =true;

        String vitoria="";
        Scanner s = new Scanner(System.in);

        iniciarJogo(velha);

        while (game){
            desenhaJogo(velha);
            vitoria= String.valueOf(verificaVitoria(velha));
            if(!vitoria.equals("")){
                System.out.printf("Jogador %s venceu%n", vitoria);
                break;
            }
            try{

                if(verificaJogada(velha,jogar(s,simboloAtual),simboloAtual)){
                    if(simboloAtual=='x'){
                        simboloAtual='o';
                    }else {
                        simboloAtual='x';
                    }
                }

            }catch (Exception e){
                throw new RuntimeException("Deu erro ai brother");
            }
        }
        System.out.println("Fim do Jogo");
    }

    public static void desenhaJogo(Campo[][] velha){
        limparTela();
        System.out.println("    0   1   2");
        System.out.printf("0   %c | %c | %c %n",velha[0][0].getSimbolo(),velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("   -----------");
        System.out.printf("1   %c | %c | %c %n",velha[1][0].getSimbolo(),velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("   -----------");
        System.out.printf("2   %c | %c | %c %n",velha[2][0].getSimbolo(),velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
    }


    //imprime espaços em branco para limpar console
    public static void limparTela(){
        for(int cont=0;cont <200;cont++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner s, char sa){
        int p[]=new int[2];
        System.out.printf("%s %c%n","Quem joga: ",sa);
        System.out.print("Informa a linha: ");
        p[0]=s.nextInt();
        System.out.print("Informe a coluna: ");
        p[1]=s.nextInt();
        return p;
    }


    //Verifica se o espaço escolhido para fazer a jogada já está preenchido
    public static Boolean verificaJogada(Campo[][] velha, int p[], char simboloAtual) {
        if (velha[p[0]][p[1]].getSimbolo() == ' ') {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }else {
            return false;
        }
    }

    public static void iniciarJogo(Campo[][] velha){
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                velha[l][c]=new Campo();
            }
        }
    }


    //realiza a verificação de quem ganhou
    public static char verificaVitoria(Campo[][] velha){
        for(int i=0;i<3;i++){
            if((velha[i][0].getSimbolo()=='X' && velha[i][1].getSimbolo()=='X' && velha[i][2].getSimbolo()=='X')||(velha[i][0].getSimbolo()=='O' && velha[i][1].getSimbolo()=='O' && velha[i][2].getSimbolo()=='O')){
                return velha[i][0].getSimbolo();
            }
        }
        for(int i=0;i<3;i++){
            if((velha[0][i].getSimbolo()=='X' && velha[1][i].getSimbolo()=='X' && velha[2][i].getSimbolo()=='X')||(velha[0][i].getSimbolo()=='O' && velha[1][i].getSimbolo()=='O' && velha[2][i].getSimbolo()=='O')){
                return velha[0][i].getSimbolo();
            }
        }
        if((velha[0][0].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][2].getSimbolo()=='X')||(velha[0][2].getSimbolo()=='O' && velha[1][1].getSimbolo()=='O' && velha[2][0].getSimbolo()=='O')){
            return velha[0][0].getSimbolo();
        }
        return ' ';
    }
}
