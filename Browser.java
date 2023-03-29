package BrowserPackage;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;



 enum Permissions {
	CAMERA,AUDIO,LOCATION;
}
 class BrwsrDef{
	 public String siteAddress=null;
	 public void whoAmI() {
		 System.out.println("I am a browser");
		 }
	
	
}

 class GoogleChrome extends BrwsrDef {
	 private boolean locationPermission;
	 private boolean cameraPermission;
	 private boolean microphonePermission;
	 private final String versionNumber;
	 
	 public GoogleChrome() {
	 super();
	 this.locationPermission = false;
	 this.cameraPermission = false;
	 this.microphonePermission = false;
	 this.versionNumber = "1.0";
	 }
	 
	 public void whoAmI() {
	 System.out.println("I am Google Chrome");
	 
	 }
	 
	 boolean isCamera = false;
	 boolean isAudio = false;
	 boolean isLocation = false;
	 
	 
	 public void setPermsn(Permissions C){
		 if(C.equals(Permissions.CAMERA)) {
			 isCamera = true;
			 System.out.println("Set permissions are(Camera,Audio,Location):"+isCamera+isAudio+isLocation);
		 }
		 
		 else if(C.equals(Permissions.AUDIO)) {
			 isAudio = true;
			 System.out.println("Set permissions are(Camera,Audio,Location):"+isCamera+isAudio+isLocation);
			 }
		 
		 else {
			 isLocation = true;	
			 System.out.println("Set permissions are(Camera,Audio,Location):"+isCamera+isAudio+isLocation);
		 }
		 
	 }

	 public void setPermsn(Permissions C,Permissions A,Permissions L) {
		 isCamera = true;
		 isAudio = true;
		 isLocation = true;
		 System.out.println("Set permissions are(Camera,Audio,Location):"+isCamera+isAudio+isLocation);
	 }
		 
	 public String getVersionNumber() {
	 return this.versionNumber;
	 }
 } 
 
 interface MultipleAccountContainers{
	 void addContainer(String newContainer);
	 void leaveContainer(String deleteContainer); }
 
	class Firefox extends BrwsrDef implements MultipleAccountContainers {
	
	private static ArrayList<String>container = new ArrayList<>();
	 public Firefox() {
	 super();
	 }
	 public void whoAmI() {
	 System.out.println("I am Firefox");
	 }
	@Override
	public void addContainer(String newContainer) {
				if (container.contains(newContainer)) {
					System.out.println("Container already present here/n");
				}
				else
					container.add(newContainer);
				System.out.println("Containers-"+container);
	}
	
	@Override
	public void leaveContainer(String deleteContainer) {
		if(container.size()==0) {
			System.out.println("Empty container list/n");
		}
		else {
			if(container.contains(deleteContainer)==false) {
				System.out.println("Invalid container/n");
			}
			else {
				container.removeIf(n-> (n.equals(deleteContainer)));
				System.out.println("Containers-"+container);
			}
			
		}
		
	}
}



public class Browser {

	
	 

	
		public static void main (String[] args) {
			Scanner in = new Scanner(System.in);
			
			char c='y';
			
			BrwsrDef tabOne = new GoogleChrome();
			BrwsrDef tabTwo = new Firefox();
			BrwsrDef tabThree = new Firefox();
			BrwsrDef tabFour = new GoogleChrome();
			BrwsrDef tabFive = new GoogleChrome();
			 
			 GoogleChrome t1 = (GoogleChrome)tabOne  ;
			 Firefox t2 = (Firefox)tabTwo;
			 Firefox t3 = (Firefox)tabThree;
			 GoogleChrome t4 = (GoogleChrome)tabFour;
			 GoogleChrome t5 = (GoogleChrome)tabFive;
			 
			 Permissions Camera = Permissions.CAMERA;
			 Permissions 
			 Audio = Permissions.AUDIO;
			 Permissions Location = Permissions.LOCATION;
			 BrwsrDef[] allBrowsers = { t1,t2,t3,t4,t5 };
				
				
				
			 
			
				do {
					System.out.println("Menu\n1.Add URLs\n2.Edit container\n3.Set permissions\n4.Number of Chrome instances\n5.Display Browsers\n");
					int choice = in.nextInt();
					
					switch(choice) {
					
					case 1: 
						System.out.println("Enter the Site addresses\n");
						for(int u =0;u<5;u++) {
							int k=0;
							String s= in.next();
							allBrowsers[u].siteAddress=s;
							for (int j =0;j<5;j++) 
								if(Objects.equals(allBrowsers[j].siteAddress, s)) {
									k++;
								}
							
								System.out.println(allBrowsers[u].siteAddress+"#"+k);

							
						}
						break;
					
					case 2:
						String containerName;
						int containerChoice;
						System.out.println("\n Container \n 1.Add Container \n 2.Remove Container\n");
						System.out.println("Enter your choice:");
						containerChoice = in.nextInt();
						switch(containerChoice)
						{
						case 1:
						System.out.println("Enter the container to add: ");
						containerName = in.next();
						((Firefox) tabTwo).addContainer(containerName);
						break;
						case 2:
						System.out.println("Enter the container to remove: ");
						containerName = in.next();
						((Firefox) tabTwo).leaveContainer(containerName);
						break;
						default:
						System.out.println("Error\n");
						}
						break;
						
					case 3:
						int newChoice=0;
						System.out.println("Enter your choice\n1.Set camera permissions\n2.Set Location permissions\n3.Set Audio permisions\n4.Set all permissions\n");
						newChoice = in.nextInt();
						switch(newChoice) {
							case 1:
								t1.setPermsn(Camera);
								break;
							
							case 2:
								 t4.setPermsn(Location);
								 break;
							
							case 3: 
								 t4.setPermsn(Audio);
								 break;
							case 4:
								 t5.setPermsn(Camera, Audio, Location);
								 break;
							default:
								System.out.println("Wrong Choice\n");
							}
						break;
					case 4:
						int numGoogleChrome = 0;
						 for (BrwsrDef browser : allBrowsers) {
						 if (browser instanceof GoogleChrome) {
							 numGoogleChrome++;
						 }
						 }
						Integer i = numGoogleChrome;
						 
						 System.out.println("Number of Google Chrome instances: " + i.intValue());
						 break;
						 
					case 5:
						for(int index = 0;index<5;index++) {
							allBrowsers[index].whoAmI();
						}
						break;
					default:
						System.out.println("Wrong Choice\n");
					}	
				
				System.out.println("Press Y/y to continue\n");
				c= in.next().charAt(0);
				}while(c=='Y'||c=='y');
				
				System.out.println("Bye!");				
				
				 
				 in.close();
				 
				 
}
}