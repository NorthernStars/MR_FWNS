package core;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import essentials.core.ArtificialIntelligence;
import fwns_network.server_2008.NetworkCommunication;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Core.class})
@PowerMockIgnore({"javax.management.*"})
public class FromServerManagementTest {

	Core mCoreMock = mock(Core.class);
	Logger mLoggerMock = mock(Logger.class);
	
	NetworkCommunication mNetworkCommunicationMock = mock(NetworkCommunication.class);
	ArtificialIntelligence mArtificialIntelligenceMock = mock(ArtificialIntelligence.class);
	
	FromServerManagement mSUT;
	
	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(Core.class);
		when(Core.getInstance()).thenReturn(mCoreMock);
		when(Core.getLogger()).thenReturn(mLoggerMock);
		
		
		
		mSUT = new FromServerManagement();
	}

	@After
	public void tearDown() throws Exception {
		if(mSUT != null){
			mSUT.stopManagement();
		}
	}

	@Test
	public void testStartManagementWithoutNetworkConnection() {
		when(mCoreMock.getServerConnection()).thenReturn( null );
		
		try{
			mSUT.startManagement();
			fail("Expected Nullpointerexception");
		} catch( Exception vExpectedException ) {
			assertThat(vExpectedException).isInstanceOf(NullPointerException.class);
			assertThat(vExpectedException.getMessage()).isEqualToIgnoringCase( "NetworkCommunication cannot be NULL when starting FromServerManagement." );
		}
	}

	@Test
	public void testStartManagementWithNetworkConnectionAndNotAlive() {
		when(mCoreMock.getServerConnection()).thenReturn( mNetworkCommunicationMock );
		when(mCoreMock.getAI()).thenReturn( null );
		
		mSUT.startManagement();
		
		assertThat(mSUT.isAlive()).isTrue();
		verify(mLoggerMock).info("FromServerManagement started.");
			
	}

	@Test
	public void testStartManagementWithNetworkConnectionAndAlive() {
		when(mCoreMock.getServerConnection()).thenReturn( mNetworkCommunicationMock );
		when(mCoreMock.getAI()).thenReturn( null );
		
		mSUT.startManagement();
		
		try{
			mSUT.startManagement();
			fail("Expected IllegalThreadStateException");
		} catch( Exception vExpectedException ) {
			assertThat(vExpectedException).isInstanceOf(IllegalThreadStateException.class);
			assertThat(vExpectedException.getMessage()).isEqualToIgnoringCase( "FromServerManagement can not be started again." );
		}
			
	}

	@Test
	public void testStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testClose() {
		fail("Not yet implemented");
	}

	@Test
	public void testResumeManagement() {
		fail("Not yet implemented");
	}

	@Test
	public void testSuspendManagement() {
		fail("Not yet implemented");
	}
	@Test
	public void testStopManagement() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsReceivingMessages() {
		fail("Not yet implemented");
	}

}
