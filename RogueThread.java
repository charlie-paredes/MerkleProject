public class RogueThread implements Runnable{
    public String sThreadName;
    public void run() {
        Util oUtil = new Util();
        while(true){

           oUtil.sleepRandomTime(sThreadName);
           String sNewWord1 = MerkleManager.grabWord();

            if (sNewWord1 != null) {
                MerkleManager.iStrikes = MerkleManager.iStrikes + 1;
                System.out.println("Rouge grabbed a word. STRIKE!!");
            }
        }
    }
}
