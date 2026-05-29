package USACO;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appointment {
		
	static class TimeSlot {
		LocalTime start;
		LocalTime end;
	
		TimeSlot(LocalTime start, LocalTime end){
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			        
			List<TimeSlot> bookedSlots = new ArrayList<>(); 
	
			System.out.println("                      === welcome ===");
			        
			while (true) {
				System.out.println("\n--- start your appointment --- (click 'exit' escape the system)");
			            
			    System.out.print("start time (eg.13:20, 09:20): ");
			    String startInput = sc.next();
			     if(startInput.equalsIgnoreCase("exit")) break;
			     
	
			    System.out.print("end time: ");
			    String endInput = sc.next();
			    if(endInput.equalsIgnoreCase("exit")) break;
	
			    try {
			    	LocalTime start = LocalTime.parse(startInput);
			        LocalTime end = LocalTime.parse(endInput);
	
			                
			        long durationMinutes = Duration.between(start, end).toMinutes();
	
			                
			        if (durationMinutes <= 0) {
			        	System.out.println("❌ Appointment failed: End time must be later than start time!");
			              continue;
			        }
	
			                
			         if (durationMinutes > 60) {
			        	 System.out.println("❌ Appointment failed. Duration is more than 1 hour.");
			             continue;
			         }
			         
			         boolean isOverlap = false;
			         for (TimeSlot slot : bookedSlots) {
			        	 if (start.isBefore(slot.end) && end.isAfter(slot.start)) {
			        		 isOverlap = true;
			                 break; 
			                 }
			         }
	
			         if (isOverlap) {
			                    System.out.println("❌ Appointment failed. The time slot is already booked.");
			         } 
			         else {
			                   bookedSlots.add(new TimeSlot(start, end));
			                    int code = (int) (Math.random() * 9000 + 1000);
			                    
			                    System.out.println("🎉 Appointment successed！");
			                    System.out.println("Your appointment: " + start + " - " + end + " (Duration: " + durationMinutes + " minutes)");
			                    System.out.println("Your code: " + code + ". Enjoy your time！");
			                }
	
			            } 
			    	catch (DateTimeParseException e) {
			                System.out.println("⚠️ Format Wrong!");
			            }
			        }
	
			        System.out.println("Exit. Thanks!");
			        sc.close();
			    
			
		}

}
