package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Lock;

public class SetLock extends Command {
    private final Lock lock;
    private final Timer timer1 = new Timer();

    public SetLock(Lock lock) {
        this.lock = lock;
        addRequirements(lock);
    }

    @Override
    public void initialize() {
        lock.setLock(1);
        timer1.reset();
        timer1.start();
        lock.isPrimed = false;
    }

    @Override
    public void execute() {
        
    }

    @Override
    public boolean isFinished() {
        return timer1.hasElapsed(8);
    }

    @Override
    public void end(boolean interrupted) {
        lock.setLock(0);
    }
}
