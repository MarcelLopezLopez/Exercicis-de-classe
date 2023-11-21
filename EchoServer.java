public class EchoServer {
    public static void main(String[] args) {
        MyServerSocket ss = new MyServerSocket(Integer.parseInt(args[0]));

        while(true){
            // Esperem la següent conexió de client
            MySocket s = ss.accept();
            // Crreem el nou thread
            new Thread(() -> {
                String line;
                while ((line = s.readLine()) != null) { 
                    // Printegem en el client   
                    s.println(line);
                    }
                    s.close();
            }).start();
        }
    }
}
