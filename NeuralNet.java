/**
 * Name: Vinit Udasi
 * Student:6847800
 * SUBJECT: COSC 3P71 FALL 2021
 * Instructor: Dr. Ombuki-Berman
 * Email:vu19pt@brocku.ca
 */
public class NeuralNet {
    float[][] output;
    float weightmatrix[][][];
    float[][] gradient; //gradient
    float[][] Derivative;
    int[] NumLayers; // a simple 4,8,1 Neural Network
    int inputSize; //  = 4
    int resultSize; // = 1
    int networkSize; // = 3
    /**
     * Initial Variables and Matrices(Multidimensional arrays)
     * */
    public NeuralNet(int[] NumLayers) {
        this.NumLayers = NumLayers;
        this.inputSize = NumLayers[0]; // input = (First Layer)
        this.networkSize = NumLayers.length;
        this.resultSize = NumLayers[networkSize - 1]; // output = (Last Layer)
        this.output = new float[networkSize][];
        this.weightmatrix = new float[networkSize][][]; // weightmatrix[layer][Currneuron][PrevNeuron]
        this.gradient = new float[networkSize][];
        this.Derivative = new float[networkSize][];
        InitialiseMatrices();
        Initialiseweightmatrix();
    }
    public void InitialiseMatrices(){
        for (int i = 0; i < networkSize; i++) {
            this.output[i] = new float[NumLayers[i]];
            this.gradient[i] = new float[NumLayers[i]];
            this.Derivative[i] = new float[NumLayers[i]];
        }
    }
    public void Initialiseweightmatrix(){
        for(int i = 0;i<networkSize;i++){
            if (i > 0) {
                weightmatrix[i] = createRandomweightmatrix(NumLayers[i], NumLayers[i - 1], -1, 1);
            }
        }
    }

/**
* @param input This is the input we train the net for
* @param targetOutput : This is the output that we expect from the net
* @param learningRate : The rate at which we want the net to learn
* @param iter: the iteration we are at currently
*
* */
    public void train(float[] input, float[] targetOutput, float learningRate,int iter) {
        feedforward(input);
        backpropagation(targetOutput);
        updateweightmatrix(learningRate);
    }
    /**
     * @param input :  Input for the forward pass
     * @return Output matrix
     * */

    public float[] feedforward(float[] input) {
        this.output[0] = input;
        for (int i = 1; i < networkSize; i++) {
            for (int j = 0; j < NumLayers[i]; j++) {
                float sum = 0f;
                for (int k = 0; k < NumLayers[i - 1]; k++) {

                    sum += output[i - 1][k] * weightmatrix[i][j][k];

                }
                output[i][j] = calc_sigmoid(sum);

                Derivative[i][j] = output[i][j] * (1 - output[i][j]);

            }
        }
        return output[networkSize - 1];
    }
    /**
     * @param targetOutput: The output we're expected
     *  This function handles the backpropogation of the error.
     * */
    public void backpropagation(float[] targetOutput) {
       //n corresponds to neuron
        for (int n = 0; n < NumLayers[networkSize - 1]; n++) {
            gradient[networkSize - 1][n] = (output[networkSize - 1][n] - targetOutput[n]) * Derivative[networkSize - 1][n];
        }

        for (int i = networkSize - 2; i > 0; i--) {
            for (int j = 0; j < NumLayers[i]; j++) {

                float sum = 0;
                for (int k = 0; k< NumLayers[i + 1]; k++) {
                    sum += weightmatrix[i + 1][k][j] * gradient[i + 1][k];
                }
                this.gradient[i][j] = sum * Derivative[i][j];
            }
        }// i - >Current Layer
         // j - > Current Neuron
         // k - > Previous Neuron
    }
    /**
     * @param learningRate: The learning rate at which network is being trained
     *
     * This function updates the weight for each epoch.
     * In loops, i -> Current layer
     *                    j -> Current Neuron
     *                    k -> Previous Neuron
     * */

    protected void updateweightmatrix(float learningRate) {
        for (int i = 1; i < networkSize; i++) {
            for (int j = 0; j < NumLayers[i]; j++) {
                float delta = -learningRate * gradient[i][j];
                for (int k = 0; k < NumLayers[i - 1]; k++) {

                    weightmatrix[i][j][k] += delta * output[i - 1][k];

                }
            }
        }
    }
    /**
     * @param input : the input we are currently working on
     * @param targetOutput : The output we're expected
     * @return  The error in Network's predicted output
     * */
    public float Error(float[] input, float[] targetOutput) {
        float sum = 0;

        for (int i = 0; i < targetOutput.length; i++) {
            sum += (targetOutput[i] - output[networkSize - 1][i]) * (targetOutput[i] - output[networkSize - 1][i]);
        }

        return (sum / (2f * targetOutput.length));

    }
    /**
     * @param width: Width of the matrix(rows)
     * @param height: height of the matrix(columns)
     * @param low: The low for creating random weights
     * @param high: The high for creating random weights
     * @return a 2d matrix with randomly generated weights
     * */
    public static float[][] createRandomweightmatrix(int width, int height, float low, float high) {
        float[][] array = new float[width][height];
        for (int i = 0; i < width; i++) {
            for(int j= 0;j<height;j++){
                array[i][j] = (float)(Math.random() * (high - low) + low);
            }
        }

        return array;
    }
    /**
     * @param x : The sigmoid of x is to be calculated.
     * @return the sigmoid of the given x
     * */
    private float calc_sigmoid(float x) {
        return (1f / (float)(1 + Math.exp(-x)));
    }

}
