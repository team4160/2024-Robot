package frc.robot.commands.Shooter;

import org.photonvision.PhotonCamera;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Swerve;

public class Shoot extends Command{
    private final Intake intake;
    private final Indexer indexer;
    private final Shooter shooter;
    // private final Swerve swerve;
    private final Timer timer = new Timer();
    double velocity;

    PhotonCamera camera = new PhotonCamera("Global_Shutter_Camera");
    final double ANGULAR_P = 0.1;
    final double ANGULAR_D = 0;
    PIDController turnController = new PIDController(ANGULAR_P, 0, ANGULAR_D);

    public Shoot(Intake intake, Indexer indexer, Shooter shooter, Swerve swerve, double velocity) {
        this.intake = intake;
        this.indexer = indexer;
        this.shooter = shooter;
        // this.swerve = swerve;
        addRequirements(intake);
        addRequirements(indexer);
        addRequirements(shooter);
        // addRequirements(swerve);
        this.velocity = velocity;
    }

    @Override
    public void initialize() {
        // if (!shooter.isLoaded)
        //     cancel();
        timer.reset();
        // shooter.percentOutput(1.0);
        shooter.shoot(velocity);
        SmartDashboard.putString("Shooter", "initialized");
    }

    @Override
    public void execute() {
        // var results = camera.getLatestResult();
        // double rotationSpeed = 0;
        // if (results.hasTargets()) {
        //     Optional<PhotonTrackedTarget> result = results.targets.stream().filter(t -> t.getFiducialId() == 4 || t.getFiducialId() == 7).findFirst();
        //     // Calculate angular turn power
        //     // -1.0 required to ensure positive PID controller effort _increases_ yaw
        //     if (result.isPresent())
        //         rotationSpeed = -turnController.calculate(result.get().getYaw(), 0);
        // }
        // swerve.drive(new Translation2d(), rotationSpeed, false, false);
        if (shooter.getVelocity() > velocity - 0.1) {
            SmartDashboard.putBoolean("Loaded", false);
            intake.setIntake(0.75);
            indexer.setIndex(0.75);
            timer.start();
        }
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(1);
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("Shooter", "finished, interrupted: " + interrupted);
        intake.setIntake(0);
        indexer.setIndex(0);
        shooter.stop();
        if (!interrupted) {
            shooter.isLoaded = false;
        }
    }
}
