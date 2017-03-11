
public class Emultor {
	
	/*
	 * how to use x86: see QA in https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3240498 
	 * 
	 * 
	 * Since I do not have access to an Android mobile device (I only have Apple devices), I needed to use the emulator exclusively to complete this course.

Of course, I ran into problems along the way. The biggest one was that during Section 5 - Automating Web Apps. Using an ARM emulator, as is used in the lessons in this section, (Section 7),  was too slow. Appium will shut down the session if it does not receive an instruction or command within 60 seconds. 

The ARM emulator is just too slow to emulate web app actions within the Appium 60 time out because web pages were loading slowly for me. 

I tried creating and running an x86 or an x86_64 emulator, but the AVD Manager kept telling me that the Intel x86 Emulator Accelerator (HAXM installer) was not installed, even though the SDK Manager showed that it was installed.

Upon researching the issue, I found out that even though the SDK Manager indicates that the HAXM installer is installed, the Intel x86 Emulator Accelerator is not installed and has to be installed manually.

(In actuality, what the SDK Manager is telling you is that the HAXM Installer is installed, which is true. But what isn't apparent is that HAXM (Hardware Accelerator) is not installed (only the installer is downloaded and installed). So you have to run the HAXM Installer manually to install the Hardware Accelerator, which allows you to use x86 and x86_64 emulators.)

To install the Intel x86 Emulator Accelerator go to C:\path\to\android\sdk\android-sdk\extras\intel\Hardware_Accelerated_Execution_Manager and run intelhaxm-android.exe. This will install the Intel x86 Emulator Accelerator.

Once this is installed, you can now use x86 and x86_64 emulators. They are much faster than the ARM emulators. Not only do they speed up app testing, but they allow web apps/pages to load much more quickly, thereby not causing a time out with Appium. In addition, the emulator loads much faster when starting it up.

Hope this helps.

Vaibhav, I recommend adding this information to lessons on the emulator as it will help out students a lot.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	 

}
