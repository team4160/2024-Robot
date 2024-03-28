package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Ingest extends Command {
    private final Intake intake;
    private final Indexer indexer;
    private final Shooter shooter;
    private boolean isSpiked;
    final double intakeCurrent = 12;
    private final Timer timer = new Timer();

    public Ingest(Intake intake, Indexer indexer, Shooter shooter) {
        this.intake = intake;
        this.indexer = indexer;
        this.shooter = shooter;
        addRequirements(intake);
        addRequirements(indexer);
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        timer.stop();
        timer.reset();
        intake.setIntakeVelocity(10);
        isSpiked = false;
    }

    @Override
    public void execute() {
        if (intake.getCurrent() > intakeCurrent && !isSpiked) {
            isSpiked = true;
            timer.start();
            SmartDashboard.putBoolean("Loaded", true);
            indexer.setIndex(-0.35);
            shooter.percentOutput(-0.10);
        }
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(1);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setIntake(0);
        indexer.setIndex(0);
        shooter.percentOutput(0);
        if (!interrupted) { 
            shooter.isLoaded = true;
        }
    }
}
