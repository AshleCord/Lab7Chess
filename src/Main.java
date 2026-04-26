public class Main{
    public static void main(String[] args) throws Exception {
        //FenReader
        //String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        FenFileReader fenFileReader = new FenFileReader();
        String[] fens = fenFileReader.readFenFile("resources/chess_positions.fen");

        for(int i = 0; i < fens.length; i++) {
            String fen = fens[i];
            System.out.println(fen);

            //Board
            Board board = new Board(fen);
            board.print();

            System.out.println("next best move is...");
            ChessApiClient chessApiClient = new ChessApiClient();
            String bestMove = chessApiClient.callRestAPIForNextMove(fen);
            //BestMove
            System.out.println("Best Move is: " + bestMove);

            //Sleep
            Thread.sleep(2000);
        }
    }
}

