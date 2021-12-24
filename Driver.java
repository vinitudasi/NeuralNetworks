import java.util.Arrays;
import java.util.Scanner;
/**
 * Name: Vinit Udasi
 * Student:6847800
 * SUBJECT: COSC 3P71 FALL 2021
 * Instructor: Dr. Ombuki-Berman
 * Email:vu19pt@brocku.ca
 */
public class Driver {
    NeuralNet net;
    NeuronPQ[] dataSetUsed;
    float learningRate ;
    int numOfEpochs ;
    int numOfHiddenNodes ;
    int NumDatasetToBeTrained;
    int choice;

    public Driver() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Learning Rate (preferred : 0.1 - 0.8, Best : 0.1 - 0.3):  ");
        learningRate = sc.nextFloat();
        System.out.print("Enter the No. of epochs :  ");
        numOfEpochs = sc.nextInt();
        System.out.print("Enter the No. of Hidden Nodes(> 0) :  ");
        numOfHiddenNodes = sc.nextInt();
        System.out.print("Enter the No. of datasets to be trained (preferred 11-13):  ");
        NumDatasetToBeTrained = sc.nextInt();
        System.out.println(" (16 - TrainedDatasets) will be tested.");
        System.out.print(" I have chosen random combination of datasets to be trained and tested \n Which combination do you want to use (1,2,3) ? ");
        choice = sc.nextInt();
        int[] layerSizes = new int[] { 4, numOfHiddenNodes, 1 };
        net = new NeuralNet(layerSizes);
        InitialiseDatasetsUsed();
        switch (choice) {
            case 1 -> createSetOne();
            case 2 -> createsetTwo();
            case 3 -> createSetThree();
            default -> createSetOne();
        }
        trainandTestNet(numOfEpochs, learningRate);
    }
    protected void InitialiseDatasetsUsed(){
        dataSetUsed = new NeuronPQ[16];
        for (int i = 0; i < dataSetUsed.length; i++) {
            dataSetUsed[i] = new NeuronPQ(4);
        }
    }
    public void createSetOne() {

        float[] in = new float[4];
        float[] out = new float[1];


        in = new float[] { 0, 0, 0, 0 };
        out = new float[] { 1 };
        dataSetUsed[0].setSample(in);
        dataSetUsed[0].setTargetOutput(out);

        in = new float[] { 0, 0, 0, 1 };
        out = new float[] { 0 };
        dataSetUsed[1].setSample(in);
        dataSetUsed[1].setTargetOutput(out);

        in = new float[] { 0, 0, 1, 0 };
        out = new float[] { 0 };
        dataSetUsed[2].setSample(in);
        dataSetUsed[2].setTargetOutput(out);

        in = new float[] { 0, 0, 1, 1 };
        out = new float[] { 1 };
        dataSetUsed[3].setSample(in);
        dataSetUsed[3].setTargetOutput(out);

        in = new float[] { 0, 1, 0, 0 };
        out = new float[] { 0 };
        dataSetUsed[4].setSample(in);
        dataSetUsed[4].setTargetOutput(out);

        in = new float[] { 0, 1, 0, 1 };
        out = new float[] { 1 };
        dataSetUsed[5].setSample(in);
        dataSetUsed[5].setTargetOutput(out);

        in = new float[] { 0, 1, 1, 0 };
        out = new float[] { 1 };
        dataSetUsed[6].setSample(in);
        dataSetUsed[6].setTargetOutput(out);

        in = new float[] { 0, 1, 1, 1 };
        out = new float[] { 0 };
        dataSetUsed[7].setSample(in);
        dataSetUsed[7].setTargetOutput(out);

        in = new float[] { 1, 0, 0, 0 };
        out = new float[] { 0 };
        dataSetUsed[8].setSample(in);
        dataSetUsed[8].setTargetOutput(out);

        in = new float[] { 1, 0, 0, 1 };
        out = new float[] { 1 };
        dataSetUsed[9].setSample(in);
        dataSetUsed[9].setTargetOutput(out);

        in = new float[] { 1, 0, 1, 0 };
        out = new float[] { 1 };
        dataSetUsed[10].setSample(in);
        dataSetUsed[10].setTargetOutput(out);

        in = new float[] { 1, 0, 1, 1 };
        out = new float[] { 0 };
        dataSetUsed[11].setSample(in);
        dataSetUsed[11].setTargetOutput(out);

        in = new float[] { 1, 1, 0, 0 };
        out = new float[] { 1 };
        dataSetUsed[12].setSample(in);
        dataSetUsed[12].setTargetOutput(out);

        in = new float[] { 1, 1, 0, 1 };
        out = new float[] { 0 };
        dataSetUsed[13].setSample(in);
        dataSetUsed[13].setTargetOutput(out);

        in = new float[] { 1, 1, 1, 0 };
        out = new float[] { 0 };
        dataSetUsed[14].setSample(in);
        dataSetUsed[14].setTargetOutput(out);

        in = new float[] { 1, 1, 1, 1 };
        out = new float[] { 1 };
        dataSetUsed[15].setSample(in);
        dataSetUsed[15].setTargetOutput(out);
    }
    void createsetTwo(){

        float[] in = new float[4];
        float[] out = new float[1];

        in = new float[] { 1, 1, 0, 0 };
        out = new float[] { 1 };
        dataSetUsed[0].setSample(in);
        dataSetUsed[0].setTargetOutput(out);

        in = new float[] { 1, 1, 0, 1 };
        out = new float[] { 0 };
        dataSetUsed[1].setSample(in);
        dataSetUsed[1].setTargetOutput(out);

        in = new float[] { 1, 1, 1, 0 };
        out = new float[] { 0 };
        dataSetUsed[2].setSample(in);
        dataSetUsed[2].setTargetOutput(out);

        in = new float[] { 1, 1, 1, 1 };
        out = new float[] { 1 };
        dataSetUsed[3].setSample(in);
        dataSetUsed[3].setTargetOutput(out);

        in = new float[] { 0, 1, 0, 0 };
        out = new float[] { 0 };
        dataSetUsed[4].setSample(in);
        dataSetUsed[4].setTargetOutput(out);

        in = new float[] { 0, 1, 0, 1 };
        out = new float[] { 1 };
        dataSetUsed[5].setSample(in);
        dataSetUsed[5].setTargetOutput(out);

        in = new float[] { 0, 1, 1, 0 };
        out = new float[] { 1 };
        dataSetUsed[6].setSample(in);
        dataSetUsed[6].setTargetOutput(out);

        in = new float[] { 0, 1, 1, 1 };
        out = new float[] { 0 };
        dataSetUsed[7].setSample(in);
        dataSetUsed[7].setTargetOutput(out);

        in = new float[] { 1, 0, 0, 0 };
        out = new float[] { 0 };
        dataSetUsed[8].setSample(in);
        dataSetUsed[8].setTargetOutput(out);

        in = new float[] { 1, 0, 0, 1 };
        out = new float[] { 1 };
        dataSetUsed[9].setSample(in);
        dataSetUsed[9].setTargetOutput(out);

        in = new float[] { 1, 0, 1, 0 };
        out = new float[] { 1 };
        dataSetUsed[10].setSample(in);
        dataSetUsed[10].setTargetOutput(out);

        in = new float[] { 1, 0, 1, 1 };
        out = new float[] { 0 };
        dataSetUsed[11].setSample(in);
        dataSetUsed[11].setTargetOutput(out);

/**-----------------------------------------Split Here(if you train 12 datasets)----------------------------------------------------------*/

        in = new float[] { 0, 0, 0, 0 };
        out = new float[] { 1 };
        dataSetUsed[12].setSample(in);
        dataSetUsed[12].setTargetOutput(out);

        in = new float[] { 0, 0, 0, 1 };
        out = new float[] { 0 };
        dataSetUsed[13].setSample(in);
        dataSetUsed[13].setTargetOutput(out);

        in = new float[] { 0, 0, 1, 0 };
        out = new float[] { 0 };
        dataSetUsed[14].setSample(in);
        dataSetUsed[14].setTargetOutput(out);

        in = new float[] { 0, 0, 1, 1 };
        out = new float[] { 1 };
        dataSetUsed[15].setSample(in);
        dataSetUsed[15].setTargetOutput(out);

    }
    public void createSetThree(){
        float[] in = new float[4];
        float[] out = new float[1];


        in = new float[] { 0, 0, 0, 0 };
        out = new float[] { 1 };
        dataSetUsed[0].setSample(in);
        dataSetUsed[0].setTargetOutput(out);

        in = new float[] { 0, 0, 0, 1 };
        out = new float[] { 0 };
        dataSetUsed[1].setSample(in);
        dataSetUsed[1].setTargetOutput(out);

        in = new float[] { 0, 0, 1, 0 };
        out = new float[] { 0 };
        dataSetUsed[2].setSample(in);
        dataSetUsed[2].setTargetOutput(out);



        in = new float[] { 1, 0, 1, 1 };
        out = new float[] { 0 };
        dataSetUsed[3].setSample(in);
        dataSetUsed[3].setTargetOutput(out);
/**-----------------------------------------Split Here-----------------------------------------------------------*/

        in = new float[] { 1, 1, 0, 0 };
        out = new float[] { 1 };
        dataSetUsed[4].setSample(in);
        dataSetUsed[4].setTargetOutput(out);

        in = new float[] { 1, 1, 0, 1 };
        out = new float[] { 0 };
        dataSetUsed[5].setSample(in);
        dataSetUsed[5].setTargetOutput(out);

        in = new float[] { 1, 1, 1, 0 };
        out = new float[] { 0 };
        dataSetUsed[6].setSample(in);
        dataSetUsed[6].setTargetOutput(out);

        in = new float[] { 1, 1, 1, 1 };
        out = new float[] { 1 };
        dataSetUsed[7].setSample(in);
        dataSetUsed[7].setTargetOutput(out);
        in = new float[] { 0, 0, 1, 1 };
        out = new float[] { 1 };
        dataSetUsed[8].setSample(in);
        dataSetUsed[8].setTargetOutput(out);

        in = new float[] { 0, 1, 0, 0 };
        out = new float[] { 0 };
        dataSetUsed[9].setSample(in);
        dataSetUsed[9].setTargetOutput(out);

        in = new float[] { 0, 1, 0, 1 };
        out = new float[] { 1 };
        dataSetUsed[10].setSample(in);
        dataSetUsed[10].setTargetOutput(out);

        in = new float[] { 0, 1, 1, 0 };
        out = new float[] { 1 };
        dataSetUsed[11].setSample(in);
        dataSetUsed[11].setTargetOutput(out);

        in = new float[] { 0, 1, 1, 1 };
        out = new float[] { 0 };
        dataSetUsed[12].setSample(in);
        dataSetUsed[12].setTargetOutput(out);

        in = new float[] { 1, 0, 0, 0 };
        out = new float[] { 0 };
        dataSetUsed[13].setSample(in);
        dataSetUsed[13].setTargetOutput(out);

        in = new float[] { 1, 0, 0, 1 };
        out = new float[] { 1 };
        dataSetUsed[14].setSample(in);
        dataSetUsed[14].setTargetOutput(out);

        in = new float[] { 1, 0, 1, 0 };
        out = new float[] { 1 };
        dataSetUsed[15].setSample(in);
        dataSetUsed[15].setTargetOutput(out);
    }


    /**
     * @param epochs: The number of epochs you want the network to be trained for
     * @param learningRate the rate at which network is learning
     * */
    public void trainandTestNet(int epochs, float learningRate) {
        float MSE=0;

        for (int i = 0,c =1; i < epochs; i++,c++) {

            MSE = 0f;

            for (int sample = 0; sample < NumDatasetToBeTrained; sample++) {
                net.train(dataSetUsed[sample].getSample(), dataSetUsed[sample].getTargetOutput(), learningRate,i+1);
                dataSetUsed[sample].setError(net.Error(dataSetUsed[sample].getSample(), dataSetUsed[sample].getTargetOutput()));
                MSE += (float)(dataSetUsed[sample].getError());
            }
            if(c % 200 == 0){
                System.out.println("The MSE for the epoch " + (i+1) +" is :  " +MSE);
            }
            System.out.println("The final MSE is :- "+ MSE);
            System.out.println("Training Complete");
            System.out.println();
            if(c == numOfEpochs){
                System.out.println("Learning rate:  " + learningRate + " ----- " + " No. of epochs: " + numOfEpochs + " ---- "
                        + " Number of hidden nodes: " + numOfHiddenNodes);
                for(int m = 0;m< NumDatasetToBeTrained;m++){
                    System.out.println();
                    System.out.println("Training Sample: " + Arrays.toString(dataSetUsed[m].getSample()) + "||" + " Expected: "
                            + Arrays.toString(dataSetUsed[m].getTargetOutput()) + "||" + " Squared Error :-  " + dataSetUsed[m].getError()
                            + " || " + " Output: " + Arrays.toString(net.feedforward(dataSetUsed[m].getSample())) );

                }
            }
        }
        System.out.println("--------------------------------------------------Testing-----------------------------------------");
        System.out.println();
        System.out.println("Learning rate:  " + learningRate + " ----- " + " No. of epochs: " + numOfEpochs + " ---- "
                + " Number of hidden nodes: " + numOfHiddenNodes);
        System.out.println();
        /**
         * Below is the testing part, The datasets which have not been trained will be tested
         * */

        for(int i = 0;i< dataSetUsed.length - NumDatasetToBeTrained;i++){
            System.out.println();
            System.out.println("Testing Example: " + Arrays.toString(dataSetUsed[i+NumDatasetToBeTrained].getSample()) + "||" + " Expected: "
                    + Arrays.toString(dataSetUsed[i].getTargetOutput()) + "||" + " Squared Error :-  " + dataSetUsed[i].getError()
                    + " || " + " Output: " + Arrays.toString(net.feedforward(dataSetUsed[i].getSample())) );

        }
    }
    public static void main(String[] args) {
        Driver driver = new Driver();

    }
}
