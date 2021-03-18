package frc.robot.subsystems;

import frc.robot.subsystems.SnailSubsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.Constants.ElectricalLayout.FRONT_SOLENOID_ID;
import frc.robot.Constants.ElectricalLayout.BACK_SOLENOID_ID;

public class Climb extends SnailSubsystem {
    private DoubleSolenoid front;
    private DoubleSolenoid back;

    public enum States {
        EXTENDED,
        REVERSED
    }

    private States state;

    public void Climb(){
        front = new DoubleSolenoid(FRONT_SOLENOID_ID);
        back = new DoubleSolenoid(BACK_SOLENOID_ID);
        state = States.REVERSED;
    }

    @Override
    public void update() {
        switch (state) {
            case EXTENDED:
                front.set(Value.kForward);
                back.set(Value.kForward);
                break;
            case REVERSED:
                front.set(Value.kReverse);
                back.set(Value.kReverse);
                break;
        }
    }

    public void extend() {
        state = States.EXTENDED;
    }

    public void reverse() {
        state = States.REVERSED;
    }

    @Override
    public void displayShuffleboard() {
        // TODO Auto-generated method stub

    }

    @Override
    public void tuningInit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void tuningPeriodic() {
        // TODO Auto-generated method stub

    }
}
