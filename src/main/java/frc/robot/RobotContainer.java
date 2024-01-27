package frc.robot;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import frc.robot.robot_subsystems.DriveSubsystem;

public class RobotContainer {
    
    public static final double GAMEPAD_AXIS_THRESHOLD = 0.2;

    public enum Autonomous {

    }

    //private Autonomous auto = null;

    private final DriveSubsystem driveSubsystem = new DriveSubsystem();

    
    Joystick driverGamepad = new Joystick(RobotConstants.Ports.CONTROLLER.JOYSTICK);

    // the container for the robot. contains subsystems, OI devices, commands
    public RobotContainer() {
        driveSubsystem.initialize();
    }
    
    public Trajectory createExampleTrajectory(TrajectoryConfig config) {
        Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
                new Pose2d(0, 0, new Rotation2d(0)),
                List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
                new Pose2d(3, 0, new Rotation2d(0)),
                config);

        return exampleTrajectory;
    }
    
    public DriveSubsystem getDriveSubsystem() {
        return driveSubsystem;
    }
}
