
package org.usfirst.frc.team2022.robot.subsystems;

import java.nio.ByteBuffer;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.RobotUtils;
import org.usfirst.frc.team2022.robot.commands.CameraCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.HSLImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *
 */
//XXX implement??
public class CameraSubsystem extends Subsystem {
	public final AxisCamera camera;
	
	public CameraSubsystem(){
		camera = new AxisCamera(RobotMap.cameraName);
		//TODO initialize camera
		//TODO Use NIVision
	}

    public void initDefaultCommand() {
        setDefaultCommand(new CameraCommand());
    }
    public HSLImage getImage() throws NIVisionException{
    	return camera.getImage();
    }
    //XXX???????????
    public byte[] getBytes() throws NIVisionException{
    	HSLImage image = getImage();
    	ByteBuffer b = RobotUtils.newDirectByteBuffer(image.image.getAddress(),
    			image.getHeight() * image.getWidth() * 3);
    	return b.array();
    }
}