package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class GetPath {
    public Command getAutonomousCommand(String path) {
        boolean isBlue = DriverStation.getAlliance().toString().equals("Blue");
        return new TrajectoryFollowerCommands(RobotContainer.s_Swerve, isBlue).followPath(path, true);
    }
}
