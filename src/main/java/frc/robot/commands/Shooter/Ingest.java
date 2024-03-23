package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Ingest extends Command {
    private final Intake intake;
    private final Indexer indexer;
    private final Shooter shooter;
    private boolean isSpiked;
    final double intakeCurrent = 35;

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
        intake.setIntakeVelocity(10);
        indexer.setIndex(-0.35);
        shooter.percentOutput(-0.10);
    }

    @Override
    public void execute() {
        if (intake.getCurrent() > intakeCurrent && !isSpiked) {
            isSpiked = true;
        }
    }

    @Override
    public boolean isFinished() {
        // if (isSpiked && intake.getCurrent() < intakeCurrent) {
        //     return true;
        // }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intake.setIntake(0);
        indexer.setIndex(0);
        shooter.percentOutput(0);
        if (!interrupted)
            shooter.isLoaded = true;
    }
}
