package mrlib.core;

import essentials.TestScenario;
import essentials.communication.worlddata_server2008.BallPosition;
import essentials.communication.worlddata_server2008.FellowPlayer;
import essentials.communication.worlddata_server2008.RawWorldData;
import essentials.communication.worlddata_server2008.ReferencePoint;
import essentials.constants.Default;
import essentials.core.BotInformation;
import essentials.core.BotInformation.Teams;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class PositionLibTests {


    final int mOwnId = 20;
    RawWorldData mWorldDataMock = mock(RawWorldData.class);
    BotInformation mSelfMock = mock(BotInformation.class);

	@Before
	public void setUp() throws Exception {

        when(mWorldDataMock.getAgentId()).thenReturn(mOwnId);

        when(mSelfMock.getRcId()).thenReturn(mOwnId);
        when(mSelfMock.getVtId()).thenReturn(mOwnId);
        when(mSelfMock.getGamevalue(BotInformation.GamevalueNames.KickRange)).thenReturn(Default.KickRange);

        when(mWorldDataMock.getFieldCenter()).thenReturn(new ReferencePoint(265.452,-7.79433,true));
        when(mWorldDataMock.getCenterLineTop()).thenReturn(new ReferencePoint(383.419,-46.6909,true));
        when(mWorldDataMock.getBluePenaltyAreaFrontTop()).thenReturn(new ReferencePoint(526.468,-22.3269, true));
        when(mWorldDataMock.getBluePenaltyAreaFrontBottom()).thenReturn(new ReferencePoint(503.287,14.6161, true));
        when(mWorldDataMock.getBlueGoalAreaFrontBottom()).thenReturn(new ReferencePoint(585.655,4.30866, true));
        when(mWorldDataMock.getBlueGoalAreaFrontTop()).thenReturn(new ReferencePoint(595.023,-11.0456, true));
        when(mWorldDataMock.getYellowPenaltyAreaFrontTop()).thenReturn(new ReferencePoint(203.578,-79.242, true));
        when(mWorldDataMock.getYellowPenaltyAreaFrontBottom()).thenReturn(new ReferencePoint(132.563,73.3422, true));
        when(mWorldDataMock.getYellowGoalAreaFrontBottom()).thenReturn(new ReferencePoint(73.6003,143.286, true));
        when(mWorldDataMock.getYellowGoalAreaFrontTop()).thenReturn(new ReferencePoint(128.363,-117.364, true));
        when(mWorldDataMock.getBallPosition()).thenReturn(new BallPosition(264.6,-8.03823, true));
        when(mWorldDataMock.getCenterLineBottom()).thenReturn(new ReferencePoint(335.932,38.4734, true));
        when(mWorldDataMock.getBlueFieldCornerBottom()).thenReturn(new ReferencePoint(685.631,17.7479,true));
        when(mWorldDataMock.getBlueGoalCornerBottom()).thenReturn(new ReferencePoint(654.481,3.85484, true));
        when(mWorldDataMock.getYellowFieldCornerBottom()).thenReturn(new ReferencePoint(245.082,121.485,true));
        when(mWorldDataMock.getYellowFieldCornerTop()).thenReturn(new ReferencePoint(306.961,-114.645,true));
        when(mWorldDataMock.getYellowGoalCornerTop()).thenReturn(new ReferencePoint(171.406,-138.311,true));
        when(mWorldDataMock.getBlueFieldCornerTop()).thenReturn(new ReferencePoint(710.106,-23.135,true));
        when(mWorldDataMock.getBlueGoalCornerTop()).thenReturn(new ReferencePoint(662.876,-9.90283,true));
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@SuppressWarnings("unused")
	@Test
	public void fuCC(){
		PositionLib vUseless = new PositionLib();
	}

	@Test
	public void testGetMiddleOfTwoReferencePoints() {
            ReferencePoint testReferencePointA;
            ReferencePoint testReferencePointB;
            ReferencePoint returnReferencePoint;
            
            testReferencePointA = new ReferencePoint(-3, 5, false);
            testReferencePointB = new ReferencePoint(2, 5, false);
            returnReferencePoint = PositionLib.getMiddleOfTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(returnReferencePoint).isExactlyInstanceOf(ReferencePoint.class);
            assertThat(returnReferencePoint.getXOfPoint()).isCloseTo(-0.5, withinPercentage(1));
            assertThat(returnReferencePoint.getYOfPoint()).isCloseTo(5, withinPercentage(1));
            
            testReferencePointA = new ReferencePoint(-2, 5, false);
            testReferencePointB = new ReferencePoint(3, 5, false);
            returnReferencePoint = PositionLib.getMiddleOfTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(returnReferencePoint).isExactlyInstanceOf(ReferencePoint.class);
            assertThat(returnReferencePoint.getXOfPoint()).isCloseTo(0.5, withinPercentage(1));
            assertThat(returnReferencePoint.getYOfPoint()).isCloseTo(5, withinPercentage(1));
            
            testReferencePointA = new ReferencePoint(-3, 5, false);
            testReferencePointB = new ReferencePoint(2.5, -1, false);
            returnReferencePoint = PositionLib.getMiddleOfTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(returnReferencePoint).isExactlyInstanceOf(ReferencePoint.class);
            assertThat(returnReferencePoint.getXOfPoint()).isCloseTo(-0.25, withinPercentage(1));
            assertThat(returnReferencePoint.getYOfPoint()).isCloseTo(2, withinPercentage(1));
            
            testReferencePointA = new ReferencePoint(-2.5, 1, false);
            testReferencePointB = new ReferencePoint(2.5, -1, false);
            returnReferencePoint = PositionLib.getMiddleOfTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(returnReferencePoint).isExactlyInstanceOf(ReferencePoint.class);
            assertThat(returnReferencePoint.getXOfPoint()).isCloseTo(0, withinPercentage(1));
            assertThat(returnReferencePoint.getYOfPoint()).isCloseTo(0, withinPercentage(1));
            
            testReferencePointA = new ReferencePoint(-3, 5, false);
            testReferencePointB = new ReferencePoint(-4, 2, false);
            returnReferencePoint = PositionLib.getMiddleOfTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(returnReferencePoint).isExactlyInstanceOf(ReferencePoint.class);
            assertThat(returnReferencePoint.getXOfPoint()).isCloseTo(-3.5, withinPercentage(1));
            assertThat(returnReferencePoint.getYOfPoint()).isCloseTo(3.5, withinPercentage(1));
            
            testReferencePointA = new ReferencePoint(0, -1, false);
            testReferencePointB = new ReferencePoint(0, 5, false);
            returnReferencePoint = PositionLib.getMiddleOfTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(returnReferencePoint).isExactlyInstanceOf(ReferencePoint.class);
//            todo: Rundungsfehler bei x und y
//            assertThat(((ReferencePoint) returnReferencePoint).getXOfPoint()).isCloseTo(0, withinPercentage(1));
//            assertThat(((ReferencePoint) returnReferencePoint).getYOfPoint()).isCloseTo(2, withinPercentage(1));
            assertThat(returnReferencePoint.getDistanceToPoint()).isCloseTo(2, withinPercentage(1));
            assertThat(returnReferencePoint.getAngleToPoint()).isCloseTo(90.0, withinPercentage(1));
	}

    @Test
    public void testGetMiddleOfGoalTeamYellow()
    {
        when(mWorldDataMock.getYellowGoalCornerBottom()).thenReturn(new ReferencePoint(135.351,161.03,true));
        when(mWorldDataMock.getYellowGoalCornerTop()).thenReturn(new ReferencePoint(171.406,-138.311,true));

        ReferencePoint returnValue = PositionLib.getMiddleOfGoal(mWorldDataMock,Teams.Blue);
        assertThat(returnValue).isExactlyInstanceOf(ReferencePoint.class);
        assertThat(returnValue.getXOfPoint()).isCloseTo(-128.0, withinPercentage(1));
        assertThat(returnValue.getYOfPoint()).isCloseTo(-35.0, withinPercentage(1));
    }

    @Test
    public void testGetMiddleOfGoalTeamBlue()
    {
        ReferencePoint returnValue = PositionLib.getMiddleOfGoal(mWorldDataMock,Teams.Yellow);
        assertThat(returnValue).isExactlyInstanceOf(ReferencePoint.class);
        assertThat(returnValue.getXOfPoint()).isCloseTo(653.0, withinPercentage(1));
        assertThat(returnValue.getYOfPoint()).isCloseTo(-35.0, withinPercentage(1));
    }

	@Test
    public void testGetMiddleOfOwnGoalTeamYellow()
    {
        when(mWorldDataMock.getYellowGoalCornerBottom()).thenReturn(new ReferencePoint(135.351,161.03,true));
        when(mWorldDataMock.getYellowGoalCornerTop()).thenReturn(new ReferencePoint(171.406,-138.311,true));

        ReferencePoint returnValue = PositionLib.getMiddleOfOwnGoal(mWorldDataMock,Teams.Yellow);
        assertThat(returnValue).isExactlyInstanceOf(ReferencePoint.class);
        assertThat(returnValue.getXOfPoint()).isCloseTo(-128.0, withinPercentage(1));
        assertThat(returnValue.getYOfPoint()).isCloseTo(-35.0, withinPercentage(1));
    }

    @Test
    public void testGetMiddleOfOwnGoalTeamBlue()
    {
        ReferencePoint returnValue = PositionLib.getMiddleOfOwnGoal(mWorldDataMock,Teams.Blue);
        assertThat(returnValue).isExactlyInstanceOf(ReferencePoint.class);
        assertThat(returnValue.getXOfPoint()).isCloseTo(653.0, withinPercentage(1));
        assertThat(returnValue.getYOfPoint()).isCloseTo(-35.0, withinPercentage(1));
    }

	@Test
	public void testIsBallInRangeOfRefPoint() {
                BallPosition testBallPos;
                ReferencePoint testReferencePoint;
                Boolean returnValue;
                
                testReferencePoint = new ReferencePoint(2, 6, false);
                testBallPos = new BallPosition(1.5, 6, false);
                returnValue = PositionLib.isBallInRangeOfRefPoint(testBallPos, testReferencePoint, 1);
                assertThat(returnValue).isExactlyInstanceOf(Boolean.class);
                assertThat(returnValue.booleanValue()).isEqualTo(true);
                
                testReferencePoint = new ReferencePoint(3, 4, false);
                testBallPos = new BallPosition(0.5, 6, false);
                returnValue = PositionLib.isBallInRangeOfRefPoint(testBallPos, testReferencePoint, 2);
                assertThat(returnValue).isExactlyInstanceOf(Boolean.class);
                assertThat(returnValue.booleanValue()).isEqualTo(false);
                
                testReferencePoint = new ReferencePoint(0.5, 7, false);
                testBallPos = new BallPosition(1.5, 6, false);
                returnValue = PositionLib.isBallInRangeOfRefPoint(testBallPos, testReferencePoint, 4);
                assertThat(returnValue).isExactlyInstanceOf(Boolean.class);
                assertThat(returnValue.booleanValue()).isEqualTo(true);
                
	}

	@Test
	public void testGetDistanceBetweenTwoRefPoints() {
            ReferencePoint testReferencePointA;
            ReferencePoint testReferencePointB;
            double distance;
            
            testReferencePointA = new ReferencePoint(-2.5, 7, false);
            testReferencePointB = new ReferencePoint(1.5,4, false);
            distance = PositionLib.getDistanceBetweenTwoRefPoints(testReferencePointA, testReferencePointB);
            assertThat(distance).isExactlyInstanceOf(Double.class);
            assertThat(((Double) distance).doubleValue()).isCloseTo(5, withinPercentage(1));
	}

    @Test
	public void testGetBestPointAwayFromBall() {


        ReferencePoint result = PositionLib.getBestPointAwayFromBall(mWorldDataMock);

        assertThat(result).isExactlyInstanceOf(ReferencePoint.class);
        assertThat(result.getDistanceToPoint()).isCloseTo(585.66, withinPercentage(1));
        assertThat(result.getAngleToPoint()).isCloseTo(4.31, withinPercentage(1));
	}



	@Test
	public void testGetAngleBetweenTwoReferencePoints() {
            ReferencePoint testReferencePointA;
            ReferencePoint testReferencePointB;
            double angle;
            
            testReferencePointA = new ReferencePoint(-1.5,6,false);
            testReferencePointB = new ReferencePoint(1.5,7,false);
            angle = PositionLib.getAngleBetweenTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(angle).isExactlyInstanceOf(Double.class);
            assertThat(((Double) angle).doubleValue()).isCloseTo(26.13, withinPercentage(1));
            
            testReferencePointA = new ReferencePoint(1.5,5,false);
            testReferencePointB = new ReferencePoint(-2,4,false);
            angle = PositionLib.getAngleBetweenTwoReferencePoints(testReferencePointA, testReferencePointB);
            assertThat(angle).isExactlyInstanceOf(Double.class);
            assertThat(((Double) angle).doubleValue()).isCloseTo(43.26, withinPercentage(1));
	}

	@Test
	public void testIsBotInQuadrangle() {
        ReferencePoint testReferencePointA;
        ReferencePoint testReferencePointB;
        ReferencePoint testReferencePointC;
        ReferencePoint testReferencePointD;
        Boolean result;

        testReferencePointA = new ReferencePoint(1,6,false);
        testReferencePointB = new ReferencePoint(-2,4,false);
        testReferencePointC = new ReferencePoint(-2.5,-1,false);
        testReferencePointD = new ReferencePoint(1.5,-2,false);
        result = PositionLib.isBotInQuadrangle(testReferencePointA, testReferencePointB, testReferencePointC, testReferencePointD);
        assertThat(result).isExactlyInstanceOf(Boolean.class);
        assertThat(result.booleanValue()).isEqualTo(true);

        testReferencePointA = new ReferencePoint(1,6,false);
        testReferencePointB = new ReferencePoint(-2,4,false);
        testReferencePointC = new ReferencePoint(-2,2,false);
        testReferencePointD = new ReferencePoint(-0.5,2,false);
        result = PositionLib.isBotInQuadrangle(testReferencePointA, testReferencePointB, testReferencePointC, testReferencePointD);
        assertThat(result).isExactlyInstanceOf(Boolean.class);
        assertThat(result.booleanValue()).isEqualTo(false);

        testReferencePointA = new ReferencePoint(0,3.5,false);
        testReferencePointB = new ReferencePoint(0,-3,false);
        testReferencePointC = new ReferencePoint(-1,3.5,false);
        testReferencePointD = new ReferencePoint(1,-1,false);
        result = PositionLib.isBotInQuadrangle(testReferencePointA, testReferencePointB, testReferencePointC, testReferencePointD);
        assertThat(result).isExactlyInstanceOf(Boolean.class);
        assertThat(result.booleanValue()).isEqualTo(false);
	}

	@Test
	public void testIsMeselfOutOfBounds() {

        Boolean result;

        result = PositionLib.isMeselfOutOfBounds(mWorldDataMock);
        assertThat(result).isExactlyInstanceOf(Boolean.class);
        assertThat(result.booleanValue()).isEqualTo(true);
	}

	@Test
	public void testIsBallInConvexQuadrangle() {


	    BallPosition ballPosition;
        ReferencePoint leftDown;
        ReferencePoint rightDown;
        ReferencePoint rightUp;
        ReferencePoint leftUp;
        Boolean result;

        leftDown = new ReferencePoint(1.5,1,false);
        rightDown = new ReferencePoint(2.5,0,false);
        rightUp = new ReferencePoint(3.5,2,false);
        leftUp = new ReferencePoint(2,3,false);

        //Ball is not in convex Quadrangle
        ballPosition = new BallPosition(1,2.5,false);

        result = PositionLib.isBallInConvexQuadrangle(leftDown,rightDown,rightUp,leftUp,ballPosition);
        assertThat(result).isExactlyInstanceOf(Boolean.class);
        assertThat(result.booleanValue()).isEqualTo(false);

        //Ball is in Triangle 1
        ballPosition = new BallPosition(2.5,2,false);

        result = PositionLib.isBallInConvexQuadrangle(leftDown,rightDown,rightUp,leftUp,ballPosition);
        assertThat(result).isExactlyInstanceOf(Boolean.class);
        assertThat(result.booleanValue()).isEqualTo(true);

        //Ball is in Triangle 2
        ballPosition = new BallPosition(2.5,1,false);

        result = PositionLib.isBallInConvexQuadrangle(leftDown,rightDown,rightUp,leftUp,ballPosition);
        assertThat(result).isExactlyInstanceOf(Boolean.class);
        assertThat(result.booleanValue()).isEqualTo(true);

    }

	@Test
	public void testAmINearestMateToPoint() {
            BotInformation testBotInfo = new BotInformation();
            testBotInfo.setVtId(20);
            testBotInfo.setRcId(20);
            RawWorldData testWorldData = TestScenario.getExampleWorldModel();
            ReferencePoint testReferencePoint;
            Boolean result;
           
            testReferencePoint = new ReferencePoint(6.0,7.0, false);
            result = PositionLib.amINearestMateToPoint(testWorldData, testReferencePoint, testBotInfo);
            assertThat(result).isExactlyInstanceOf(Boolean.class);
            assertThat(result.booleanValue()).isEqualTo(true);
            
            testWorldData = TestScenario.getExampleWorldModel();
            FellowPlayer testFellowPlayer = new FellowPlayer(21, "Nearest Mate", true, 5.83, 30.96, 0.0);
            testWorldData.setFellowPlayer(testFellowPlayer);
            result = PositionLib.amINearestMateToPoint(testWorldData, testReferencePoint, testBotInfo);
            assertThat(result).isExactlyInstanceOf(Boolean.class);
            assertThat(result.booleanValue()).isEqualTo(false);

	}

	@Test
	public void testLawOfCosine() {
            double testSideA;
            double testSideB;
            double testSideC;
            double angle;

            testSideA = 15.9;
            testSideB = 14.5;
            testSideC = 22.5;
            angle = PositionLib.lawOfCosine(testSideA, testSideB, testSideC);
            assertThat(angle).isExactlyInstanceOf(Double.class);
            assertThat(((Double) angle).doubleValue()).isCloseTo(39.9, withinPercentage(1));
            
            testSideA = 12.1;
            testSideB = 10.4;
            testSideC = 22.5;
            angle = PositionLib.lawOfCosine(testSideA, testSideB, testSideC);
            assertThat(angle).isExactlyInstanceOf(Double.class);
            assertThat(((Double) angle).doubleValue()).isCloseTo(0.0, withinPercentage(1));
            
            testSideA = 10.81;
            testSideB = 37.04;
            testSideC = 31.0;
            angle = PositionLib.lawOfCosine(testSideA, testSideB, testSideC);
            assertThat(angle).isExactlyInstanceOf(Double.class);
            assertThat(((Double) angle).doubleValue()).isCloseTo(116.0, withinPercentage(1));
            
//            testSideA = -44.5;
//            testSideB = 55.3;
//            testSideC = 22.3;
//            angle = PositionLib.lawOfCosine(testSideA, testSideB, testSideC);
//            assertThat(angle).isExactlyInstanceOf(Double.class);
//            assertThat(((Double) angle).doubleValue()).isCloseTo(0.0, withinPercentage(1));
                
        }

	@Test
	public void testIsBallInTriangle() {
            ReferencePoint testRefPointA;
            ReferencePoint testRefPointB;
            ReferencePoint testRefPointC;
            BallPosition testBallPos;
            Boolean result;
            
            testBallPos = new BallPosition(-0.5, 1, false);
            testRefPointA = new ReferencePoint(0.5, -1, false);
            testRefPointB = new ReferencePoint(-0.5, 3, false);
            testRefPointC = new ReferencePoint(-1.5, -1, false);
            result = PositionLib.isBallInTriangle(testRefPointA, testRefPointB, testRefPointC, testBallPos);
            assertThat(result).isExactlyInstanceOf(Boolean.class);
            assertThat((result).booleanValue()).isEqualTo(true);
            
            testBallPos = new BallPosition(0, 1, false);
            testRefPointA = new ReferencePoint(1,1,false);
            testRefPointB = new ReferencePoint(0,3, false);
            testRefPointC = new ReferencePoint(1,3, false);
            result = PositionLib.isBallInTriangle(testRefPointA, testRefPointB, testRefPointC, testBallPos);
            assertThat(result).isExactlyInstanceOf(Boolean.class);
            assertThat((result).booleanValue()).isEqualTo(false);
            
            testBallPos = new BallPosition(0.5, 4, false);
            result = PositionLib.isBallInTriangle(testRefPointA, testRefPointB, testRefPointC, testBallPos);
            assertThat(result).isExactlyInstanceOf(Boolean.class);
            assertThat((result).booleanValue()).isEqualTo(false);
            
            testBallPos = new BallPosition(1.5, 2, false);
            result = PositionLib.isBallInTriangle(testRefPointA, testRefPointB, testRefPointC, testBallPos);
            assertThat(result).isExactlyInstanceOf(Boolean.class);
            assertThat((result).booleanValue()).isEqualTo(false);
            
            testBallPos = new BallPosition(1.5, 2.69, false);
            result = PositionLib.isBallInTriangle(testRefPointA, testRefPointB, testRefPointC, testBallPos);
            assertThat(result).isExactlyInstanceOf(Boolean.class);
            assertThat((result).booleanValue()).isEqualTo(false);
	}

}
