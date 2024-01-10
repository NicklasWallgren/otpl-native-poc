package dev.nicklasw.otel;

import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservationApplication {

    @Bean
    public SpanExporter otlpSpanExporter() {
        return OtlpGrpcSpanExporter.builder()
            .setEndpoint("http://localhost:4317")
            .build();
    }

    @Bean
    public MetricExporter otlpMetricExporter() {
        return OtlpGrpcMetricExporter.builder()
            .setEndpoint("http://localhost:4317")
            .build();
    }

    public static void main(final String[] args) {
        SpringApplication.run(ObservationApplication.class, args);
    }

}
