package JDBC;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient>, java.io.Serializable 
	{
	
		public int compare(Patient p1, Patient p2) {
			String pat1 = p1.getPatient_ID();
			String pat2 = p2.getPatient_ID();

			if ( pat1.compareTo(pat2)>=1)
				
				return 1;
				else 
					if (pat1.compareTo(pat2)<1)
					return -1;
				else
					return 0;
		
	}

}
