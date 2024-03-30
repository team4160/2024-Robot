package frc.lib.util;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.math.util.Units;

/* Contains values and required settings for common COTS swerve modules. */
public class COTSTalonFXSwerveConstants {
    public final double wheelDiameter;
    public final double wheelCircumference;
    public final double angleGearRatio;
    public final double driveGearRatio;
    public final double angleKP;
    public final double angleKI;
    public final double angleKD;
    public final InvertedValue driveMotorInvert;
    public final InvertedValue angleMotorInvert;
    public final SensorDirectionValue cancoderInvert;

    public COTSTalonFXSwerveConstants(double wheelDiameter, double angleGearRatio, double driveGearRatio, double angleKP, double angleKI, double angleKD, InvertedValue driveMotorInvert, InvertedValue angleMotorInvert, SensorDirectionValue cancoderInvert){
        this.wheelDiameter = wheelDiameter;
        this.wheelCircumference = wheelDiameter * Math.PI;
        this.angleGearRatio = angleGearRatio;
        this.driveGearRatio = driveGearRatio;
        this.angleKP = angleKP;
        this.angleKI = angleKI;
        this.angleKD = angleKD;
        this.driveMotorInvert = driveMotorInvert;
        this.angleMotorInvert = angleMotorInvert;
        this.cancoderInvert = cancoderInvert;
    }

    /** West Coast Products */
    public static final class WCP {
        /** West Coast Products - SwerveX Standard*/
        public static final class SwerveXStandard{
            /** West Coast Products - SwerveX Standard (Falcon 500)*/
            public static final COTSTalonFXSwerveConstants Falcon500(double driveGearRatio){
                double wheelDiameter = Units.inchesToMeters(4.0);

                /** (396 / 35) : 1 */
                double angleGearRatio = ((396.0 / 35.0) / 1.0);

                double angleKP = 1.0;
                double angleKI = 0.0;
                double angleKD = 0.0;

                InvertedValue driveMotorInvert = InvertedValue.CounterClockwise_Positive;
                InvertedValue angleMotorInvert = InvertedValue.Clockwise_Positive;
                SensorDirectionValue cancoderInvert = SensorDirectionValue.CounterClockwise_Positive;
                return new COTSTalonFXSwerveConstants(wheelDiameter, angleGearRatio, driveGearRatio, angleKP, angleKI, angleKD, driveMotorInvert, angleMotorInvert, cancoderInvert);
            }

            /** West Coast Products - SwerveX Standard (Kraken X60)*/
            public static final COTSTalonFXSwerveConstants KrakenX60(double driveGearRatio){
                double wheelDiameter = Units.inchesToMeters(4.0);

                /** (396 / 35) : 1 */
                double angleGearRatio = ((396.0 / 35.0) / 1.0);

                double angleKP = 1.0;
                double angleKI = 0.0;
                double angleKD = 0.0;

                InvertedValue driveMotorInvert = InvertedValue.CounterClockwise_Positive;
                InvertedValue angleMotorInvert = InvertedValue.Clockwise_Positive;
                SensorDirectionValue cancoderInvert = SensorDirectionValue.CounterClockwise_Positive;
                return new COTSTalonFXSwerveConstants(wheelDiameter, angleGearRatio, driveGearRatio, angleKP, angleKI, angleKD, driveMotorInvert, angleMotorInvert, cancoderInvert);
            }

            public static final class driveRatios{
                /** WCP SwerveX Standard X1 - 10 Tooth - (7.85 : 1) */
                public static final double X1_10 = (7.85 / 1.0);

                /** WCP SwerveX Standard X1 - 11 Tooth - (7.13 : 1) */
                public static final double X1_11 = (7.13 / 1.0);

                /** WCP SwerveX Standard X1 - 12 Tooth - (6.54 : 1) */
                public static final double X1_12 = (6.54 / 1.0);

                /** WCP SwerveX Standard X2 - 10 Tooth - (6.56 : 1) */
                public static final double X2_10 = (6.56 / 1.0);

                /** WCP SwerveX Standard X2 - 11 Tooth - (5.96 : 1) */
                public static final double X2_11 = (5.96 / 1.0);

                /** WCP SwerveX Standard X2 - 12 Tooth - (5.46 : 1) */
                public static final double X2_12 = (5.46 / 1.0);

                /** WCP SwerveX Standard X3 - 12 Tooth - (5.14 : 1) */
                public static final double X3_12 = (5.14 / 1.0);

                /** WCP SwerveX Standard X3 - 13 Tooth - (4.75 : 1) */
                public static final double X3_13 = (4.75 / 1.0);

                /** WCP SwerveX Standard X3 - 14 Tooth - (4.41 : 1) */
                public static final double X3_14 = (4.41 / 1.0);
            }
        }

        /** West Coast Products - SwerveX Flipped*/
        public static final class SwerveXFlipped{
            /** West Coast Products - SwerveX Flipped (Falcon 500)*/
            public static final COTSTalonFXSwerveConstants Falcon500(double driveGearRatio){
                double wheelDiameter = Units.inchesToMeters(4.0);

                /** (468 / 35) : 1 */
                double angleGearRatio = (12.1558441558442 / 1.0);

                double angleKP = 24;
                double angleKI = 1e-4;
                double angleKD = 0.0;

                // InvertedValue driveMotorInvert = InvertedValue.CounterClockwise_Positive;
                InvertedValue driveMotorInvert = InvertedValue.Clockwise_Positive;
                InvertedValue angleMotorInvert = InvertedValue.Clockwise_Positive;
                SensorDirectionValue cancoderInvert = SensorDirectionValue.CounterClockwise_Positive;
                return new COTSTalonFXSwerveConstants(wheelDiameter, angleGearRatio, driveGearRatio, angleKP, angleKI, angleKD, driveMotorInvert, angleMotorInvert, cancoderInvert);
            }

            /** West Coast Products - SwerveX Flipped (Kraken X60)*/
            public static final COTSTalonFXSwerveConstants KrakenX60(double driveGearRatio){
                double wheelDiameter = Units.inchesToMeters(4.0);

                /** (468 / 35) : 1 */
                double angleGearRatio = (12.1558441558442 / 1.0);

                double angleKP = 1.0;
                double angleKI = 0.0;
                double angleKD = 0.0;

                InvertedValue driveMotorInvert = InvertedValue.Clockwise_Positive;
                InvertedValue angleMotorInvert = InvertedValue.Clockwise_Positive;
                SensorDirectionValue cancoderInvert = SensorDirectionValue.CounterClockwise_Positive;
                return new COTSTalonFXSwerveConstants(wheelDiameter, angleGearRatio, driveGearRatio, angleKP, angleKI, angleKD, driveMotorInvert, angleMotorInvert, cancoderInvert);
            }

            public static final class driveRatios{
                /** WCP SwerveX Flipped X1 - 10 Tooth - (8.10 : 1) */
                public static final double X1_10 = (8.10 / 1.0);

                /** WCP SwerveX Flipped X1 - 11 Tooth - (7.36 : 1) */
                public static final double X1_11 = (7.36 / 1.0);

                /** WCP SwerveX Flipped X1 - 12 Tooth - (6.75 : 1) */
                public static final double X1_12 = (6.75 / 1.0);

                /** WCP SwerveX Flipped X2 - 10 Tooth - (6.72 : 1) */
                public static final double X2_10 = (6.72 / 1.0);

                /** WCP SwerveX Flipped X2 - 11 Tooth - (6.11 : 1) */
                public static final double X2_11 = (6.11 / 1.0);

                /** WCP SwerveX Flipped X2 - 12 Tooth - (5.60 : 1) */
                public static final double X2_12 = (5.60 / 1.0);

                /** WCP SwerveX Flipped X3 - 10 Tooth - (5.51 : 1) */
                public static final double X3_10 = (5.51 / 1.0);

                /** WCP SwerveX Flipped X3 - 11 Tooth - (5.01 : 1) */
                public static final double X3_11 = (5.01 / 1.0);

                /** WCP SwerveX Flipped X3 - 12 Tooth - (4.59 : 1) */
                public static final double X3_12 = (4.59 / 1.0);
            }
        }
    }
}
