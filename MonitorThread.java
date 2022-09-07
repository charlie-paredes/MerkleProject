public class MonitorThread implements Runnable{
    Util oUtil = new Util();
    public void run() {
        while (true){
        if (MerkleManager.sMerkleRoot != null) {

            if (MerkleManager.sMerkleRoot.equals(MerkleManager.sUserMerkleRoot)) {
                System.out.println("You win! ");
                System.out.println("Merkle Root: " + MerkleManager.sMerkleRoot);
                System.exit(0);
            } else if (!MerkleManager.sMerkleRoot.equals(MerkleManager.sUserMerkleRoot)) {
                System.out.println("You lost. ");
                System.exit(0);
            }
        }
            else if (MerkleManager.iStrikes == 3){
                System.out.println("Three Strikes: You lost! ");
                System.exit(0);
            }
            oUtil.sleep(1);
        }
    }
}
