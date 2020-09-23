# Mocking in cpp

### A perfect example

An example from the googlemock:

```cpp
class Clock {
public:
    virtual uint64_t epoch();
    virtual uint64_t rdtsc();
    virtual std::zoned_time for_tz(std::chrono::time_zone tz); 
};

class MockClock {
public:
  MOCK_METHOD(uint64_t, epoch_time, ());
  MOCK_METHOD(std::zoned_time, for_tz, (std::chrono::time_zone));
};
```

+ Partial implementation (rdtsc is not implemented)

- All-virtual functions
- Basically, a new language


### A sample of template code contamination

```
   // Production stack      // Test stack

   Level0::func             MockLevel0::func
   Level1::func             Level1<MockLevel0>::func
   Level2::func             Level2<MockLevel0>::func
   Level3::func             Level3<MockLevel0>::func
   Level4::func             Test::doTest
   ...
```
