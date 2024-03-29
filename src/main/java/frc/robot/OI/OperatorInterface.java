package frc.robot.OI;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.CommandFactory;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.commands.ArmRotateCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.XCommand;
import frc.robot.robot_subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OperatorInterface {

        private final XboxController driveJoystick = new XboxController(RobotConstants.Ports.CONTROLLER.DRIVER_JOYSTICK);

        public OperatorInterface(CommandFactory commandFactory, RobotContainer robotContainer) {
                

                //TODO: Button numbers need to be changed
                new JoystickButton(driveJoystick, 2).onTrue(commandFactory.gyroResetCommand());
                new JoystickButton(driveJoystick, 3).onTrue(new XCommand());
                robotContainer.getDriveSubsystem()
                                .setDefaultCommand(new DriveCommand(robotContainer.getDriveSubsystem(), driveJoystick));
                
                robotContainer.getArmSubsystem()
                                .setDefaultCommand(commandFactory.defaultRotate());
        }
}
