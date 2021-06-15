package nl.paulzijlmans.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListTest {

  @Mock
  List<String> listMock;

  @Test
  public void testSize() {
    when(listMock.size()).thenReturn(10);
    assertEquals(10, listMock.size());
  }

  @Test
  public void testSize_multipleReturns() {
    when(listMock.size()).thenReturn(10).thenReturn(20);
    assertEquals(10, listMock.size());
    assertEquals(20, listMock.size());
    assertEquals(20, listMock.size());
  }

  @Test
  public void testGet_SpecificParameter() {
    when(listMock.get(0)).thenReturn("SomeString");
    assertEquals("SomeString", listMock.get(0));
    assertNull(listMock.get(1));
  }

  @Test
  public void testGet_GenericParameter() {
    when(listMock.get(anyInt())).thenReturn("SomeString");
    assertEquals("SomeString", listMock.get(0));
    assertEquals("SomeString", listMock.get(1));
  }
}
