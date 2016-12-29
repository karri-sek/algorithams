package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sortingballs.base.impl.Rack;
import com.sortingballs.base.impl.TreeSortObserver;
import com.sortingballs.base.model.Ball;

public class SortingBallTest {

    TreeSortObserver treeSortObserver = new TreeSortObserver();

    Rack rack = new Rack();

    @Test
    public final void whenObserverIsRegisteredThenCountOfObserversShouldIncrement() {
	rack.registerObserver(treeSortObserver);
	Assert.assertEquals(1, rack.getNoOfObservers());
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void throwsUnsupportedOperationExceptionWhenNoObserversAreRegistered() {
	rack.add(new Ball(30));
    }
    

    @Test
    public final void whenNoBallsAddedToTheRackThenLeaderBoardShouldBeEmpty() {
	rack.registerObserver(treeSortObserver);
	Assert.assertEquals(true, rack.getBalls().isEmpty());
    }

    @Test
    public final void whenBallOfValue30isAddedThenLeaderBoardShouldDisplayBallWith30Value() {
	rack.registerObserver(treeSortObserver);
	rack.add(new Ball(30));
	Assert.assertEquals(1, rack.getBalls().size());
	for (Ball ball : rack.getBalls()) {
	    Assert.assertEquals(30, ball.getValue());
	}
    }

    @Test
    public final void whenBallsOfValues40And10areAddedThenLeaderBoardShouldDisplayBallInAscendingSortOrder() {
	rack.registerObserver(treeSortObserver);
	rack.add(new Ball(40));
	rack.add(new Ball(10));
	List<Ball> listOfBallsInLeaderBoard = rack.getBalls();
	Assert.assertEquals(2, listOfBallsInLeaderBoard.size());
	int index = 0;
	for (Ball ball : listOfBallsInLeaderBoard) {
	    if (index == 0) {
		Assert.assertEquals(10, ball.getValue());
	    } else {
		Assert.assertEquals(40, ball.getValue());
	    }
	    index++;
	}
    }

    @Test
    public final void whenBallsOfValues40And30And20And10areAddedThenLeaderBoardShouldDisplayBallInAscendingSortOrder() {
		rack.registerObserver(treeSortObserver);
		rack.add(new Ball(40));
		rack.add(new Ball(30));
		rack.add(new Ball(20));
		rack.add(new Ball(10));
		List<Ball> ballsInOrder = rack.getBalls();
		Assert.assertEquals(4, ballsInOrder.size());
		int index = 0;
		for (Ball ball : ballsInOrder) {
			if (index == 0) {
				Assert.assertEquals(10, ball.getValue());
			} else if (index == 1) {
				Assert.assertEquals(20, ball.getValue());
			} else if (index == 2) {
				Assert.assertEquals(30, ball.getValue());
			} else if (index == 3) {
				Assert.assertEquals(40, ball.getValue());
			}
			index++;
		}
	}
		@Test
		public final void whenBallsOfValues30And20And10areAddedThenLeaderBoardShouldDisplayBallInAscendingSortOrder() {
			List<Integer> expected = Arrays.asList(10,20,30);
			List<Integer> actual = new LinkedList();
			rack.registerObserver(treeSortObserver);
			rack.add(new Ball(30));
			rack.add(new Ball(20));
			rack.add(new Ball(10));
			List<Ball> listOfBalls = rack.getBalls();
			Assert.assertEquals(3, listOfBalls.size());
			for(Ball ball:listOfBalls){
				actual.add(ball.getValue());
			}
			Assert.assertEquals(expected,actual);
    }
}
