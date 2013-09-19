import java.util.Scanner;

    public class TicTacToe {

        //игровое поле
//        static char [][] field = new char [3][3];

//        //ооздание игрового поля
//        static void init(){
//            for (int i=0;i<field.length;i++) {
//                for (int j=0; i < field[i].length; j++) {
//                    field[i][j] = ' ';
//                }
//            }
//        }

        static char[][] field =
                {   { ' ', ' ', ' ' },
                        { ' ', ' ', ' ' },
                        { ' ', ' ', ' ' } };
//
//        //вывод текущего состояния игры на консоль
//        static void showField(){
//            for (int i=0;i<field.length;i++) {
//                for (int j=0; i < field[i].length; j++) {
//                    System.out.println(field[i][j] + "|");
//                    System.out.println();
//                    System.out.println("------");
//                }
//            }
//        }

        public static void showField() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(field[i][j] + "|");
                }
                System.out.println();
            }
        }

        //ход компьютера
        static void pcMove(){
        int x = (int) Math.random()*3;
            int y = (int) Math.random()*3;
            while (field [x][y]== 'O' || field [x][y]== 'X'){
                x = (int) Math.random()*3;
                y = (int) Math.random()*3;
            }
            field [x][y] = 'O';
        }

        //ход пользователя
        static void userMove(){
            int x, y;
            System.out.println("Please, enter x (1..3): ");
            x = Integer.parseInt(new Scanner(System.in).nextLine())-1;
            System.out.println("Please, enter y (1..3): ");
            y = Integer.parseInt(new Scanner(System.in).nextLine())-1;
            while (field [x][y]== 'O' || field [x][y]== 'X' || x<0 || y<0 || x>2 || y>2){
                System.out.println("Please, enter x: ");
                x = Integer.parseInt(new Scanner(System.in).nextLine())-1;
                System.out.println("Please, enter y: ");
                y = Integer.parseInt(new Scanner(System.in).nextLine())-1;
            }
            field[x][y] = 'X';
        }

        //остались ли на игровом поле свободные клетки
        static boolean checkField(){
            boolean cf = false;
        for (int i=0;i<field.length;i++) {
            for (int j=0; i < field[i].length; j++) {
                if (field[i][j] == ' '){
                    cf = true;
                break;
            }
        }
                if (cf=true){
                    break;
                }
            }
        return cf;
        }


        //проверка победителя
        static char checkGame(){
            char winner = ' ';
        for (int i=0;i<field.length;i++) {
            if (field[i][0]==field[i][1] && field[i][0] == field[i][2]){
                winner =  field[i][0];
                break;
            }
                if (field[0][i] == field[1][i] && field[0][i] == field[2][i]){
                    winner = field[0][i];
                    break;
                }
                    if(field [0][0] == field[1][1] && field [1][1] == field [2][2]){
                        winner =  field [0][0];
                    }
                    if(field [0][2] == field[1][1] && field[1][1] == field[2][0]){
                           winner =  field[0][2];
                    }
                }
                        return winner;
        }


        public static void main(String[] args){
            System.out.println("Welcome to TicTacToe! Game started! P.S. You is 'X' ");
            //init();
            showField();
            while (checkGame() == ' ' && checkField()){
                userMove();
                pcMove();
                showField();
            }

            if (checkGame() == 'X'){
                System.out.println("Congrats! You win!");
            }
                if (checkGame() == 'O'){
                    System.out.println("Loser!");
                }
                    if (checkGame() == ' ' && checkField()){
                        System.out.println("Standoff");
                    }
        }
    }