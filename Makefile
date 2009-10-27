include Makefile.common

install: modelica_java.jar $(antlr)
	cp -u $< $(antlr) ../../build/share/java
modelica_java.jar: $(java_sources)
	rm -rf bin-jar; mkdir bin-jar
	@"$(JAVAC)" -cp "$(antlr)" -d bin-jar $(java_sources)
	$(JAR) cf $@ $(java_sources:src/%=-C src %) $(resources:src/%=-C src %) -C bin-jar . || (rm $@ && false)
test: $(java_sources)
	rm -rf bin-test; mkdir bin-test
	@"$(JAVAC)" -cp "$(antlr):$(junit)" -d bin-test $(java_sources) $(java_tests)
	$(JAVA) -cp "bin-test:src:$(antlr):$(junit)" org.junit.runner.JUnitCore $(junit_tests)
