public class MerkleManager {
    public static volatile String sUserWord;
    public static String sUserMerkleRoot;
    public static String sMerkleRoot = null;
    public static int iStrikes = 0;

    //method called by MerkleManager_Test
    public void manage(){
    Util oUtil = new Util();

    //using
    sUserMerkleRoot = oUtil.promptUser("enter expected Merkle Root");

    // step 1. create instance of the target class
    MonitorThread oMonitor1 = new MonitorThread();
    MerkleThread oMerkle1 = new MerkleThread();
    oMerkle1.sThreadName = "merkle";
    RogueThread oRogue1 = new RogueThread();
    oRogue1.sThreadName = "rogue";

    //step 2. instantiate a Thread class and pass in the above object
    Thread oThread1 = new Thread(oMonitor1);
    Thread oThread2 = new Thread(oMerkle1);
    Thread oThread3 = new Thread(oRogue1);

    //step 3. call the start method on the Thread instance.
    oThread1.start();
    oThread2.start();
    oThread3.start();

    while(true){
        sUserWord = oUtil.promptUser("enter a word");
        }
    }

    public static synchronized String grabWord(){
        String sTemp = sUserWord;
        sUserWord = null;
        return sTemp;
    }
}
