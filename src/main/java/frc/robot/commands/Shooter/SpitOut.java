package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class SpitOut extends Command {
    private final Intake intake;
    private final Indexer indexer;
    private final Shooter shooter;

    public SpitOut(Intake intake, Indexer indexer, Shooter shooter) {
        this.intake = intake;
        this.indexer = indexer;
        this.shooter = shooter;
        addRequirements(intake);
        addRequirements(indexer);
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        intake.setIntake(-.5);
        indexer.setIndex(-.5);
        shooter.percentOutput(-.5);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setIntake(0);
        indexer.setIndex(0);
        shooter.percentOutput(0);
    }
}
