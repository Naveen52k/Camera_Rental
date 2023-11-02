package LoginScreen;

public class ViewAllCameras{

	public static void view(){
		
		System.out.println("List of All Available Camera: ");
		
				
		if(CameraOperations.cameraList.isEmpty()) {
			
			System.out.println("No Cameras available at the moment");
			
		}
		
		else {
			System.out.println("+====================================================+");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","CAMERA ID", "BRAND", "MODEL", "PRICE", "STATUS");
			System.out.println("+====================================================+");
            int id = 1;
            
            
           
            for(CameraOperations camera:CameraOperations.cameraList) {
            	System.out.printf("%-10s %-10s %-10s %-10.2f %-10s\n",id++, camera.getBrand(), camera.getModel(),
                        camera.getPricePerDay(), camera.isRented() ? "Rented" : "Available");

            }
		
	}

	}

	
}
