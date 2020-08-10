import java.io.*;

public class Main_function {
public static void main(String[] args) throws IOException {
    	
        float probability;
        int[] states = new int[]{0,1,2};
        int[] emissions;
        Float[][] transition_probability;
        double[][] emisssion_probability;
        double[] starting_probability = new double[]{(double) 1 / (double) 3, (double) 1 / (double) 3, (double) 1 / (double) 3};
    	
    	File file=new File(".\\src\\InputFile.txt");
    	FileReader fr=new FileReader(file);     
    	BufferedReader r1 = new BufferedReader(fr);
    	
    	r1.readLine();
    	r1.readLine();
    	r1.readLine();   	   	    	
    	probability = Float.parseFloat(r1.readLine());
        transition_probability = new Float[][]
        {
            {probability, (1 - probability) / 2, (1 - probability) / 2},
            {(1 - probability) / 2, probability, (1 - probability) / 2},
            {(1 - probability) / 2, (1 - probability) / 2, probability},
        };
        
    	r1.readLine();

        emisssion_probability = new double[3][3];
        for (int i = 0; i < 3; i++) 
        {
            String[] emit_prob = r1.readLine().split(" ");
            for(int j =0;j<3;j++)
            {
                emisssion_probability[i][j] = Double.parseDouble(emit_prob[j]);
            }
        }
        
    	r1.readLine();
    	r1.readLine();

        String[] e1 = r1.readLine().split(",");
        emissions = new int[100];
        for(int i = 0;i<100;i++)
        {
            emissions[i] = Integer.parseInt(e1[i]);
        }
        
        r1.close();  
        Viterbi_algorithm v = new Viterbi_algorithm();
        v.viterbi_fun(states, starting_probability, transition_probability, emissions, emisssion_probability);      
    }
}
