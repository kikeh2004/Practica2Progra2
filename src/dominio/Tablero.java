
    package dominio;
    /**
     * Esta clase es responsable de leer el tablero de un
     * fichero en forma de ceros y unos, ir transitando de
     * estados e ir mostrando dichos estados.
     */
    public class Tablero{

        private static int dimension = 30;

        private int[][] estadoDespues = new int[dimension][dimension];

        private int[][] estadoInicial = generarEstadoActualPorMontecarlo();

        public static int[][] generarEstadoActualPorMontecarlo(){
            int[][] matrizinic = new int[dimension][dimension];
            Random rnd = new Random();
            for(int i = 0; i < dimension; i++){
                for(int j = 0; j < dimension; j++){
                    if (rnd.nextDouble() < 0.5){
                        matrizinic[i][j] = 0;
                    }else{
                        matrizinic[i][j] = 1;
                    }
                }
            }
            return matrizinic;
        }

        public void imprimirEstadoActualPorMontecarlo(){
            for(int a = 0; a < dimension; a++){
                for(int b = 0; b < dimension; b++){
                    System.out.printf("%2d", estadoInicial[a][b]);
                }
                System.out.println();
            }
        }
        public void transitarAlEstadoSiguiente(){
            int vecinosVivos = 0;
            for(int a = 0; a < dimension; a++){
                for(int b = 0; b < dimension; b++){
                    if (a == 0 && b == 0){
                        vecinosVivos = estadoInicial[a][b+1] + estadoInicial[a+1][b] + estadoInicial[a+1][b+1];
                    }else if(a == 0 && b == dimension-1){
                        vecinosVivos = estadoInicial[a][b-1] + estadoInicial[a+1][b] + estadoInicial[a+1][b-1];
                    }else if(a == dimension-1 && b == 0){
                        vecinosVivos = estadoInicial[a-1][b] + estadoInicial[a][b+1] + estadoInicial[a-1][b+1];
                    }else if(a == dimension-1 && b == dimension-1){
                        vecinosVivos = estadoInicial[a-1][b] + estadoInicial[a][b-1] + estadoInicial[a-1][b-1];
                    }else if(a == 0){
                        vecinosVivos = estadoInicial[a][b-1] + estadoInicial[a+1][b-1] + estadoInicial[a+1][b]
                                + estadoInicial[a+1][b+1] + estadoInicial[a][b+1];
                    }else if(a == dimension-1){
                        vecinosVivos = estadoInicial[a][b-1] + estadoInicial[a-1][b-1] + estadoInicial[a-1][b]
                                + estadoInicial[a-1][b+1] + estadoInicial[a][b+1];
                    }else if(b == 0){
                        vecinosVivos = estadoInicial[a-1][b] + estadoInicial[a-1][b+1] + estadoInicial[a][b+1]
                                + estadoInicial[a+1][b+1] + estadoInicial[a+1][b];
                    }else if(b == dimension-1){
                        vecinosVivos = estadoInicial[a-1][b] + estadoInicial[a-1][b-1] + estadoInicial[a][b-1]
                                + estadoInicial[a+1][b-1] + estadoInicial[a+1][b];
                    }else{
                        vecinosVivos = estadoInicial[a][b-1] + estadoInicial[a][b+1] + estadoInicial[a+1][b]
                                + estadoInicial[a-1][b] + estadoInicial[a+1][b-1] + estadoInicial[a+1][b+1]
                                + estadoInicial[a-1][b-1] + estadoInicial[a-1][b+1];
                    }

                    if (estadoInicial[a][b] == 1 && (vecinosVivos == 2 | vecinosVivos == 3)){
                        estadoDespues[a][b] = 1;
                        System.out.print("x" + " ");
                    }else if(estadoInicial[a][b] == 0 && vecinosVivos == 3){
                        estadoDespues[a][b] = 1;
                        System.out.print("x" + " ");
                    }else{
                        estadoDespues[a][b] = 0;
                        System.out.print(" " + " ");
                    }
                }
                System.out.println();
            }
            estadoInicial = estadoDespues;
        }
    }