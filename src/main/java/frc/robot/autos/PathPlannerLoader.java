package frc.robot.autos;

import java.util.HashMap;
import java.util.List;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.SwerveAutoBuilder;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Swerve;

public class PathPlannerLoader {
    public static Command getAutoCommand(Swerve driveSubsystem, String name) {
        List<PathPlannerTrajectory> pathGroup = PathPlanner.loadPathGroup(name, new PathConstraints(4.4, 3));
        
        HashMap<String, Command> eventMap = new HashMap<>();
        // eventMap.put("marker1", new PrintCommand("Passed marker 1"));  not used
        // eventMap.put("intakeDown", new IntakeDown());  not used

        SwerveAutoBuilder autoBuilder = new SwerveAutoBuilder(
            driveSubsystem::getPose, // TODO ckack if it work 
            driveSubsystem::resetOdometry, // Pose2d consumer, used to reset odometry at the beginning of auto
            Constants.Swerve.swerveKinematics, // SwerveDriveKinematics
            new PIDConstants(Constants.AutoConstants.kPXController, 0.0, 0.0), // PID constants to correct for translation error (used to create the X and Y PID controllers)
            new PIDConstants(Constants.AutoConstants.kPYController, 0.0, 0.0), // PID constants to correct for rotation error (used to create the rotation controller)
            driveSubsystem::setModuleStates, // Module states consumer used to output to the drive subsystem
            eventMap,
            true, // Should the path be automatically mirrored depending on alliance color. Optional, defaults to true
            driveSubsystem // The drive subsystem. Used to properly set the requirements of path following commands
        );

        System.out.println("resetting position to start of path " + pathGroup.get(0).getInitialPose());
        driveSubsystem.resetOdometry(pathGroup.get(0).getInitialPose());

        return autoBuilder.fullAuto(pathGroup);
    }
}