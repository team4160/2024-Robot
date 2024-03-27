package frc.robot.commands.Autos;

import com.pathplanner.lib.commands.FollowPathHolonomic;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.math.controller.HolonomicDriveController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import frc.robot.Constants;
import frc.robot.subsystems.Swerve;


public class TrajectoryFollowerCommands {

    private Swerve s_swerve;
    private HolonomicDriveController controller;
    private HolonomicPathFollowerConfig config;
    private boolean isBlue;
    public TrajectoryFollowerCommands(Swerve subsystem, boolean isBlueAlliance) {
        this.isBlue = isBlueAlliance;
        this.config = new HolonomicPathFollowerConfig(
                new PIDConstants(1, 0 ,0),
                new PIDConstants(1, 0,0),
                Constants.Swerve.maxSpeed,
                Constants.Swerve.maxRadius,
                new ReplanningConfig(true, false)
                );
        s_swerve = subsystem;

    }

    public FollowPathHolonomic followPath(String chosenPath, boolean startingPath) {

        PathPlannerPath path = PathPlannerPath.fromPathFile(chosenPath);

        if(startingPath)
            s_swerve.swerveOdometry.resetPosition(path.getPoint(0).rotationTarget.getTarget(), s_swerve.getModulePositions(), path.getStartingDifferentialPose());

        return new FollowPathHolonomic(
                path,
                s_swerve::getPose,
                s_swerve::getLatestSpeeds,
                (ChassisSpeeds chassisSpeeds) -> s_swerve.driveChassisSpeeds(chassisSpeeds, true),
                this.config,
                () -> this.isBlue,
                s_swerve
        );
    }
}
