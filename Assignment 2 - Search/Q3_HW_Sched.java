import java.util.*;

public class Q3_HW_Sched {
	ArrayList<Q3_Assignment> Assignments = new ArrayList<Q3_Assignment>();
	int m;
	int lastDeadline = 0;
	
	protected Q3_HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Q3_Assignment homework = new Q3_Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}
	
	
	/**
	 * 
	 * @return Array where output[i] corresponds to the assignment 
	 * that will be done at time i.
	 */
	public int[] SelectAssignments() {

		//Sort assignments
		//Order will depend on how compare function is implemented
		Collections.sort(Assignments, new Q3_Assignment());
		
		// If homeworkPlan[i] has a value -1, it indicates that the 
		// i'th timeslot in the homeworkPlan is empty
		//homeworkPlan contains the homework schedule between now and the last deadline
		int[] homeworkPlan = new int[lastDeadline];
		for (int i=0; i < homeworkPlan.length; ++i) {
			homeworkPlan[i] = -1;
		}


		//With the sort function, it sorted with the assignment with the bigger weight first
		for(Q3_Assignment assignment : Assignments){

			//We start with the assignment with the biggest deadline
			for(int i = assignment.deadline - 1; i >= 0 ; i--){

				//If the slot with assignment deadline date is empty
				if(homeworkPlan[i] == -1){
					//Add that assignment to the plan
					homeworkPlan[i] = assignment.number;
					//Stop the loop to not get duplicates
					break;
					
				}

			}

		}

		
		return homeworkPlan;
	}
}
	



