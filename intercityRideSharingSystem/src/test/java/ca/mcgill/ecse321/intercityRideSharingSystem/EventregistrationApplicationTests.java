package ca.mcgill.ecse321.intercityRideSharingSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.OngoingStubbing;

import ca.mcgill.ecse321.intercityRideSharingSystem.Controller.intercityRideSharingSystemController;
import ca.mcgill.ecse321.intercityRideSharingSystem.Repository.intercityRideSharingSystemRepository;
import ca.mcgill.ecse321.intercityRideSharingSystem.Model.User;
import ca.mcgill.ecse321.intercityRideSharingSystem.Model.User.Rating;
import ca.mcgill.ecse321.intercityRideSharingSystem.Model.User.Status;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventregistrationApplicationTests {

	@Mock
	private intercityRideSharingSystemRepository participantDao;

	@InjectMocks
	private intercityRideSharingSystemController controller;

	private static final String PARTICIPANT_KEY = "TestParticipant";
	private static final String PARTICIPANT_ROLE = "Driver";
	private static Integer PARTICIPANT_ID;
	private static String TEMPSTRING;
	private User participant;
	private static final String Start = "start";
	private static final String Stops = "stop1_stop2";
	private static final String VehiculeType = "suv";
	private static final String driver = "Driver";
	private static final String Seating = "seating";
	private Rating rating;
	private Status status;

	private static final String NONEXISTING_KEY = "NotAParticipant";

	@Before
	public void setMockOutput() {
		when(participantDao.getUserbyName(anyString())).thenAnswer((InvocationOnMock invocation) -> {
			if (invocation.getArgument(0).equals(PARTICIPANT_KEY)) {
			    participant = new User();
				participant.setName(PARTICIPANT_KEY);
				participant.setRole(PARTICIPANT_ROLE);
				participant.setRating(rating);
				participant.setStatus(status);
				return participant;
			} else {
				return null;
			}
		});
	}

	@Test
	public void testParticipantQueryFound() {
		//String expectedResult = "User [id=null, userName #TestParticipant# userRole=Driver, status=null,rating=null ]";
		//@SuppressWarnings()
		String getResult = controller.queryUserName(PARTICIPANT_KEY); 
		//String getResult = participantDao.getUser(PARTICIPANT_KEY); 
		assertEquals(PARTICIPANT_KEY, getResult);
	}

	@Test
	public void testParticipantQueryNotFound() {
		assertEquals(controller.queryUser(NONEXISTING_KEY), "Not Found");
	}


}