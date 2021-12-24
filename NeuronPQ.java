/**
 * Name: Vinit Udasi
 * Student:6847800
 * SUBJECT: COSC 3P71 FALL 2021
 * Instructor: Dr. Ombuki-Berman
 * Email:vu19pt@brocku.ca
 */
import java.util.*;
public class NeuronPQ {
    float[] Sample;
    float[] targetOutput;
    float MSE;

    public NeuronPQ(int size) {
        this.Sample = new float[size];
        this.targetOutput = new float[1];
    }
    /**
     * This is a utility class for a neuron in the network
     * This class implements the designNeuron interface which is nothing but an initial design of a single Neuron
     * Getters ans setters are defined for the network below
     * get the error and set the error
     * get the sample and set the sample, sample being the dataset
     * get the target output and set the target output
     */

    void setError(float MSE) {
        this.MSE = MSE;
    }
    float getError() {
        return MSE;
    }

    void setSample(float[] input) {
        this.Sample = input;
    }
    float[] getSample() {
        return Sample;
    }

    void setTargetOutput(float[] targetOutput) {
        this.targetOutput = targetOutput;
    }
    float[] getTargetOutput() {
        return this.targetOutput;
    }
}