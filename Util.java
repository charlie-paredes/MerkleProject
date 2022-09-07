import java.security.SecureRandom;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

public class Util {
    public String getMerkleRoot (ArrayList<String> listItems){
        //hard coded number of items to 4
        //Here we're creating all the nodes in the merkle tree using the MerkleNode class
        MerkleNode oNode1 = new MerkleNode();
        MerkleNode oNode2 = new MerkleNode();
        MerkleNode oNode3 = new MerkleNode();
        MerkleNode oNode4 = new MerkleNode();
        MerkleNode oNode5 = new MerkleNode();
        MerkleNode oNode6 = new MerkleNode();
        MerkleNode oNode7 = new MerkleNode();

        //the first four nodes are passed into generateHash to get their hash
        oNode1.sHash = generateHash(listItems.get(0));
        oNode2.sHash = generateHash(listItems.get(1));
        oNode3.sHash = generateHash(listItems.get(2));
        oNode4.sHash = generateHash(listItems.get(3));
        /* oNode1 and oNode2 are passed to populateMerkleNode, which adds their hashes together
         * and passes that to generateHash to get a hash for oNode5. Same idea for oNode6 and oNode7. */
        populateMerkleNode(oNode5, oNode1, oNode2);
        populateMerkleNode(oNode6, oNode3, oNode4);
        populateMerkleNode(oNode7, oNode5, oNode6);

        return oNode7.sHash;
    }

    /*method to add the hashes of two nodes together
    and pass them to generateHash, creating a hash for the combination of hashes.
     */
    private void populateMerkleNode (MerkleNode oNode, MerkleNode oLeftNode,
                                     MerkleNode oRightNode){
        oNode.oLeft = oLeftNode;
        oNode.oRight = oRightNode;
        oNode.sHash = generateHash(oNode.oLeft.sHash + oNode.oRight.sHash);
    }

    //code for this function was given on Canvas. Generates a hash.
    public synchronized String generateHash(String sOriginal){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){
            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }
    public String promptUser(String sQuestion){
        JOptionPane oQuestion = new JOptionPane();
        String sAnswer = oQuestion.showInputDialog(sQuestion);
        return sAnswer;
    }

    public void sleepRandomTime(String sThreadName){

        // Gets random number between 0 and 5 and then adds 3, meaning between 3 and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;

        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }
    public void sleep(int iSeconds){
        try{ Thread.sleep(iSeconds * 1000);
        }
        catch (Exception ex){

        }
    }
}
