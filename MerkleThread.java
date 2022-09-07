import java.util.ArrayList;

public class MerkleThread implements Runnable{
    public String sThreadName;
    public static volatile ArrayList<String> listWords;
    private int iMerkleTreeInputs = 4;

    public void run() {
    Util oUtil = new Util();
    listWords = new ArrayList<>();

    while(true) {
         oUtil.sleepRandomTime(sThreadName);
        String sNewWord = MerkleManager.grabWord();

        if (sNewWord != null) {
            System.out.println("Merkle grabbed a word");
            listWords.add(sNewWord);

        if (listWords.size() == iMerkleTreeInputs) {
           MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(listWords);
                }
            }
         }
    }
}
