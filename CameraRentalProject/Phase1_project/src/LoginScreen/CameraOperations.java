package LoginScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CameraOperations {

	private String Brand;
	private String Model;
	private double PricePerDay;
	private boolean isRented;

   
	public CameraOperations(String brand, String model, double pricePerDay) {
		super();
		Brand = brand;
		Model = model;
		PricePerDay = pricePerDay;
		this.isRented = false;
	}

    public static List<CameraOperations> cameraList = new ArrayList<>();
	

    public void previouslist() {
    	CameraOperations cam=new CameraOperations("canon", "d700", 6000);
    	
    	cameraList.add(cam);
    }

	public String getBrand() {
		return Brand;
	}


	public String getModel() {
		return Model;
	}


	public double getPricePerDay() {
		return PricePerDay;
	}


	public boolean isRented() {
		return isRented;
	}



	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}





	@Override
	public String toString() {
		return "CameraOperations [Brand=" + Brand + ", Model=" + Model + ", PricePerDay=" + PricePerDay + ", isRented="
				+ isRented + "]";
	}



	public static void remove(int id) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);

		displayAllCameras();
		System.out.print("Enter the camera ID to remove: ");
        int cameraId =scan.nextInt();


        if(cameraId>0 && cameraId<=cameraList.size()) {
        	cameraList.remove(cameraId);
        	System.out.println("Camera successfully removed from the list.");
        }
        else {
        	System.out.println("CameraId not found");
        }
	}

	public static void displayAllCameras() {
		// TODO Auto-generated method stub
		
		if(cameraList.isEmpty()) {
			System.out.println("Your Camera list is empty");
		}
		else {
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","CAMERA ID", "BRAND", "MODEL", "PRICE", "STATUS");
            int id = 0;
            
            for(CameraOperations camera:cameraList) {
            	System.out.printf("%-10s %-10s %-10s %-10.2f %-10s\n",id++, camera.getBrand(), camera.getModel(),
                        camera.getPricePerDay(), camera.isRented() ? "Rented" : "Available");

            }

		}
		
	}


	public static  void addCamera() {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);

		System.out.println("Enter the camera brand: ");
		String brand=scan.next();

		System.out.println("Enter the camera model: ");
		String model=scan.next();

		System.out.println("Enter Price/day (INR): ");
		double PricePerDay=scan.nextDouble();



		CameraOperations camera=new CameraOperations(brand, model, PricePerDay);
		cameraList.add(camera);
        System.out.println("Your camera has been successfully added to the list.");
	}

	
	public static void rentCamera() {
		Scanner sc=new Scanner(System.in);
		
		displayAllCameras();
		
		if(cameraList.isEmpty()) {
			System.out.println("Now,No camera available for rent");
			return;
		}
		
	System.out.println("Enter the camera id you want to rent");
	
	int cameraId=sc.nextInt();
	
	if(cameraId>=0 && cameraId<cameraList.size()) {
		CameraOperations camera=cameraList.get(cameraId);
		
		if(camera.isRented()) {
			System.out.println("Already rented");
		}
		
		else {
			if(Wallet.getBalance()>=camera.getPricePerDay()) {
				
				Wallet.withdraw(camera.getPricePerDay());
				camera.setRented(true);
				
				String output="Your Transaction for camera"+camera.getBrand() +" "+camera.getModel()+" With RENT INR." +camera.getPricePerDay()+"HAS SUCCESSFULLY COMPLETED";
				System.out.println(output);
			}
			else {
				System.out.println("Insufficient wallet balance,please refill your wallet");
			}
		}
	}
	
	else {
		System.out.println("Invalid Camera id");
	}
	
	}
	
	

}
