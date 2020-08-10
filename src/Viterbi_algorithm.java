
public class Viterbi_algorithm {
	
	public  void viterbi_fun( int[] states, double[] starting_probability, Float[][] transition_probability, int[] emissions, double[][] emisssion_probability) 
	{		
        int[][] seq = new int[states.length][emissions.length];
        double[][] viterbi = new double[states.length][emissions.length]; 

        for (int s : states)   // Variables are initialized
        { 
	        viterbi[s][0] = starting_probability[s] * emisssion_probability[s][emissions[0] - 1];
	        seq[s][0] = s;
        }

        for (int e = 1; e < emissions.length; e++) {  
            int[][] temp = new int[states.length][emissions.length]; 
            
            for (int s : states) {  
                double final_probability = -1;
                int current_state;
                for (int s1 : states) {
                    double current_p = viterbi[s1][e - 1] * transition_probability[s1][s] * emisssion_probability[s][emissions[e] - 1];
                    if (current_p > final_probability) { 
                        current_state = s1;
                        final_probability = current_p;
                        viterbi[s][e] = final_probability;  // records probability
                        System.arraycopy(seq[current_state], 0, temp[s], 0, e);  // Saves path found
                        temp[s][e] = s;
                    }
                }
            }
            seq = temp;
        }
        
        double final_probability = -1;
        int state = 0;
        
        
        // finds maximum probability 
        for (int s : states) {     

            if (viterbi[s][emissions.length - 1] > final_probability) {
                final_probability = viterbi[s][emissions.length - 1];
                state = s;
            }
        }       
        
        // gives sequence that has highest probability
        StringBuffer sequence = new StringBuffer();
        for (int s : seq[state]) {
            sequence.append("D"+(s+1)+" ");
        }
        
                
        System.out.println("Probability of the sequence is: " + final_probability);
        System.out.println("Sequence is: " + sequence.toString());
    }
}
