package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command{
    private final Intake intake;
    private final Indexer indexer;
    private final Shooter shooter;
    private final Timer timer = new Timer();
    double velocity;

    public Shoot(Intake intake, Indexer indexer, Shooter shooter, double velocity) {
        this.intake = intake;
        this.indexer = indexer;
        this.shooter = shooter;
        addRequirements(intake);
        addRequirements(indexer);
        addRequirements(shooter);
        this.velocity = velocity;
    }

    @Override
    public void initialize() {
        // if (!shooter.isLoaded)
        //     cancel();
        timer.reset();
        shooter.shoot(velocity);
        SmartDashboard.putString("Shooter", "initialized");
    }

    @Override
    public void execute() {
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
