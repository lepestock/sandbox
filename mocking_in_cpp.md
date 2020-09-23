# Mocking in cpp

## Vritual Methods

some sample

```
Some basic code
Second code line
```

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
